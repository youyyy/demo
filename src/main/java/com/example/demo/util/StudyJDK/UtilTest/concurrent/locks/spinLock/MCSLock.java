package com.example.demo.util.StudyJDK.UtilTest.concurrent.locks.spinLock;/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: demo
 * @description: 自旋锁的一种实现
 * @author: youyi
 * @create: 2020/9/10
 **/
public class MCSLock {
    private AtomicReference<QNode> tail;
    private ThreadLocal<QNode> myNode;

    public MCSLock() {
        tail = new AtomicReference<>(null);
        myNode = ThreadLocal.withInitial(QNode::new);
    }

    public void lock() {
        QNode qnode = myNode.get();
        QNode preNode = tail.getAndSet(qnode);
        if (preNode != null) {
            qnode.locked = false;
            preNode.next = qnode;
            //wait until predecessor gives up the lock
            while (!qnode.locked) {
            }
        }
        qnode.locked = true;
    }

    public void unlock() {
        QNode qnode = myNode.get();
        if (qnode.next == null) {
            //后面没有等待线程的情况
            if (tail.compareAndSet(qnode, null)) {
                //真的没有等待线程，则直接返回，不需要通知
                return;
            }
            //wait until predecessor fills in its next field
            // 突然有人排在自己后面了，可能还不知道是谁，下面是等待后续者
            while (qnode.next == null) {
            }
        }
        //后面有等待线程，则通知后面的线程
        qnode.next.locked = true;
        qnode.next = null;
    }

    private class QNode {
        /**
         * 是否被qNode所属线程锁定
         */
        private volatile boolean locked = false;
        /**
         * 与CLHLock相比，多了这个真正的next
         */
        private volatile QNode next = null;
    }

    public static void main(String[] args) {
        MCSLock lock = new MCSLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("log");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }


}
