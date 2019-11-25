package com.example.demo.util.studyThread.java多线程编程核心技术.第三章.myt1;

/**
 * @program: demo
 * @description: 测试notify是否必须要执行完synchronized代码块之后才释放锁
 * author: youyi
 * @create: 2019-11-10 17:46
 **/
public class Service {
    //wait
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() thread name " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("  end wait() thread name" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // notify
    public void synNotifyMethod(Object lock) {
        try {
            // 如果
//            System.out.println("begin notify() thread name " + Thread.currentThread().getName());
//            synchronized (lock) {
//                lock.notify();
//            }
//            System.out.println("给我等着");
//            Thread.sleep(5000);
//            System.out.println("等完了");
//
//            System.out.println("  end notify() thread name " + Thread.currentThread().getName());
//
            // 是这个先抢到锁还是wait先抢到，不确定
            synchronized (lock){
                System.out.println("begin notify() thread name " + Thread.currentThread().getName());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("  end notify() thread name " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA aThread = new ThreadA(lock);
        NotifyThread notifyThread = new NotifyThread(lock);
        SynNotifyMethodThread synNotifyMethodThread = new SynNotifyMethodThread(lock);
        aThread.start();
        notifyThread.start();
        synNotifyMethodThread.start();
    }
}

