package com.example.demo.util.StudyJDK.UtilTest.concurrent.locks;/*
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

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: demo
 * @description: 读写锁
 * @author: youyi
 * @create: 2021/9/3
 **/
public class ReentrantReadWriteLockTest {


    private static Object ob = null;
    private final static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private Object get(){
        rwl.readLock().lock();
        try{
            return ob;
        }finally {
            rwl.readLock().unlock();
        }
    }

    private Object set(Object o){
        rwl.writeLock().lock();
        try{
            System.out.println("===========");
            System.out.println("old="+ob);
            ob = o;
            System.out.println("new="+ob);
            System.out.println("===========");
            return o;
        }finally {
            rwl.writeLock().unlock();
        }
    }
    private static ExecutorService pool = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100), new ThreadFactoryBuilder().setNameFormat("[youyi]--").build(),new ThreadPoolExecutor.CallerRunsPolicy());
    public static void main(String[] args) {
        ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();
        for (int i = 0; i < 100; i++) {
            pool.submit(()->{
                System.out.println("reader="+test.get());
            });
        }
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            pool.submit(()->{
                test.set("i="+ finalI);
            });
        }

    }





}
