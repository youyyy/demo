package com.example.demo.util.StudyJDK.UtilTest.concurrent.MyThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-08 11:19
 **/
public class MyExecutors {
    static ExecutorService pool =  Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return 1;
            }
        };
        Future future =  pool.submit(callable);
        System.out.println("等待");
        Thread.sleep(1000);
        System.out.println(future.get());
        System.out.println("完成");
    }
}
