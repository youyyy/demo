package com.example.demo.util.StudyJDK.threadTest;

/**
 * @program: demo
 * @description: description 用方法体写 测试加锁与join是一致的
 * @author: youyi
 * @create: 2019-10-06 15:56
 **/
public class ThreadTest {
    //
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(Thread.currentThread().getName());
        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        t1.start();   // t1线程
        // main线程也持有t1对象锁
        synchronized(t1){
            while(t1.isAlive()) { // 只要线程t1存活就可以进入循环
                t1.wait(0);
            }
        }
        t2.start();   // t2线程

    }
}
