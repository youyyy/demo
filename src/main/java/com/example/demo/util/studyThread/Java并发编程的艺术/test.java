package com.example.demo.util.studyThread.Java并发编程的艺术;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-02 15:29
 **/
public class test {
    Lock lock = new ReentrantLock();
    Condition a =  lock.newCondition();
    Condition b = lock.newCondition();
    public void read(){
        lock.lock();
        try {
            while (true){
                a.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
