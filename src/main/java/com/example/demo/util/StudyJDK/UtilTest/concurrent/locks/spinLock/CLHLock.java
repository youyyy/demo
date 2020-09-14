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
public class CLHLock{

    /**
     * 锁等待队列的尾部
     */
    private AtomicReference<QNode> tail;
    private ThreadLocal<QNode> preNode;
    private ThreadLocal<QNode> myNode;

    public CLHLock() {
        tail = new AtomicReference<>(null);
        myNode = ThreadLocal.withInitial(QNode::new);
        preNode = ThreadLocal.withInitial(() -> null);
    }

    public void lock() {
        QNode qnode = myNode.get();
        //设置自己的状态为locked=true表示需要获取锁
        qnode.locked = true;
        //链表的尾部设置为本线程的qNode，并将之前的尾部设置为当前线程的preNode
        QNode pre = tail.getAndSet(qnode);
        preNode.set(pre);
        if(pre != null) {
            //当前线程在前驱节点的locked字段上旋转，直到前驱节点释放锁资源
            while (pre.locked) {
                System.out.println(Thread.currentThread().getName()+"自旋");
            }
        }
    }

    public void unlock() {
        QNode qnode = myNode.get();
        //释放锁操作时将自己的locked设置为false，可以使得自己的后继节点可以结束自旋
        qnode.locked = false;
        //回收自己这个节点，从虚拟队列中删除
        //将当前节点引用置为自己的preNode，那么下一个节点的preNode就变为了当前节点的preNode，这样就将当前节点移出了队列
        myNode.set(preNode.get());
    }

    private class QNode {
        /**
         * true表示该线程需要获取锁，且不释放锁，为false表示线程释放了锁，且不需要锁
         */
        private volatile boolean locked = false;
    }

    public static void main(String[] args) {
        CLHLock lock = new CLHLock();
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
