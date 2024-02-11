package com.example.demo.util.StudyJDK.threadTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: description  测试ThreadLocal
 * @author: youyi
 * @create: 2019-10-10 20:26
 **/
public class ThreadLocalExample {


    public static class MyRunnable implements Runnable {


        private ThreadLocal threadLocal = new ThreadLocal();

        private ThreadLocal<Map<String,Object>> threadLocal2 = ThreadLocal.withInitial(HashMap::new);


        @Override

        public void run() {

            threadLocal.set((int) (Math.random() * 100D));
            // 每一个线程的ThreadLocal如果只有一个，那么重复set没用
            threadLocal.set((int) (Math.random() * 100D));

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {


            }

            System.out.println("线程："+Thread.currentThread().getName()+"，threadLocalMap里的value="+threadLocal.get());

        }

    }


    public static void main(String[] args) {

        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);

        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();

        thread2.start();

    }


}
