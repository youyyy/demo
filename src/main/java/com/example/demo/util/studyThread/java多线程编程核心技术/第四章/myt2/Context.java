package com.example.demo.util.studyThread.java多线程编程核心技术.第四章.myt2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: 生产者消费者模式
 * @author: youyi
 * @create: 2019-11-12 15:06
 **/
public class Context {
    private List<String> list = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    private Condition addCondition = lock.newCondition();
    private Condition removeCondition = lock.newCondition();

    public void add(String value){
        lock.lock();
        try{
            while (list.size()>=10) {
                addCondition.await();
            }
            list.add(value);
            System.out.println("添加之后size = " + list.size());
            removeCondition.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void remove(){
        lock.lock();
        try{
            while (list.size()<1) {
                removeCondition.await();
            }
            list.remove(0);
            System.out.println(Thread.currentThread().getName()+"删除之后size = " + list.size());
            addCondition.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
