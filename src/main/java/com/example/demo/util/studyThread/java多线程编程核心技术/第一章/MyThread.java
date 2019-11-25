package com.example.demo.util.studyThread.java多线程编程核心技术.第一章;

/**
 * @program: demo
 * @description: 共享数据和不共享数据
 * @author: youyi
 * @create: 2019-11-06 16:04
 **/
public class MyThread extends Thread {
    private int count = 5;
    @Override
    public void run(){
        super.run();
        count--;
        System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
    }
    // 加锁
//    @Override
//    synchronized public void run(){
//        super.run();
//        count--;
//        System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
//    }


    public static void main(String[] args) {
        // 共享数据 存在数据一致性的问题
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"e");


        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
