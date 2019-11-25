package com.example.demo.util.StudyJDK.UtilTest.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-15 14:33
 **/
public class AQSTest {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            AQSTest o = new AQSTest();
            o.conditionTest();
        });
    }
    public void conditionTest(){
        lock.lock();
        try{

            conditionA.await();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
