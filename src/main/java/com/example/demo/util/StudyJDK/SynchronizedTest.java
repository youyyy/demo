package com.example.demo.util.StudyJDK;

/**
 * @program: demo
 * @description: 同步 测试
 * Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：
 *
 * 普通同步方法（实例方法），锁是当前实例对象 ，进入同步代码前要获得当前实例的锁
 * 静态同步方法，锁是当前类的class对象 ，进入同步代码前要获得当前类对象的锁
 * 同步方法块，锁是括号里面的对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。
 *
 * @author: youyi
 * @create: 2019-09-30 10:08
 **/
public class SynchronizedTest implements Runnable{
    //共享资源
    static int i =0;
    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }
    // 两个线程实例化两个不同的对象，但是访问的方法是静态的，
    // 两个线程发生了互斥（即一个线程访问，另一个线程只能等着），
    // 因为静态方法是依附于类而不是对象的，当synchronized修饰静态方法时，锁是class对象。
    public static synchronized void staticIncrease(){
        i++;
    }
    @Override
    public void run(){
        // 实现Runnable接口 充血Run函数  用start启动
        for (int j =0 ; j<10000;j++){
            increase();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);



    }
}
