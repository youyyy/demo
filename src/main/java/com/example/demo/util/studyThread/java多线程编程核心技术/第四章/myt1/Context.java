package com.example.demo.util.studyThread.java多线程编程核心技术.第四章.myt1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: Lock的使用和Condition的使用方式
 * @author: youyi
 * @create: 2019-11-12 14:30
 **/
public class Context {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await(){
        lock.lock();
        try {
            System.out.println("await,time="+System.currentTimeMillis());
            condition.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void signal(){
        lock.lock();
        try{
            System.out.println("signal,time="+System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Context con = new Context();
        ThreadA threadA = new ThreadA(con);
        threadA.start();
        Thread.sleep(3000);
        con.signal();
    }
}
