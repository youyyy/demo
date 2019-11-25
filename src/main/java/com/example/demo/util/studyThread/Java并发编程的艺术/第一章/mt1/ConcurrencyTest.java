package com.example.demo.util.studyThread.Java并发编程的艺术.第一章.mt1;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-24 15:30
 **/
public class ConcurrencyTest {
    /** 执行次数 */
    private static final long count = 10000000;

    public static void main(String[] args) throws InterruptedException {
        //并发计算
        concurrency();
        //单线程计算
        serial();
    }

    private static void concurrency() throws InterruptedException {

        long start = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
                System.out.println(a);
            }
        });

        thread.start();

        int b = 0;

        for (long i = 0; i < count; i++) {
            b--;
        }

        // 这一行是保证两个线程都必须执行完才能打印时间
        thread.join();

        long time = System.currentTimeMillis() - start;

        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {

        long start = System.currentTimeMillis();

        int a = 0;

        for (long i = 0; i < count; i++) {
            a += 5;
        }

        int b = 0;

        for (long i = 0; i < count; i++) {
            b--;
        }

        long time = System.currentTimeMillis() - start;

        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
