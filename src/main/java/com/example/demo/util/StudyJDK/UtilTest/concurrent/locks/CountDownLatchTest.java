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

import java.util.concurrent.*;

/**
 * @program: demo
 * @description: CountDownLatch
 * @author: youyi
 * @create: 2021/9/3
 **/
public class CountDownLatchTest {

    private static final ExecutorService pool = new ThreadPoolExecutor(2,4,0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100), new ThreadFactoryBuilder().setNameFormat("[youyi]---").build(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
                pool.submit(()->{
                    try {
                        System.out.println(finalI);
                    }
                    finally {
                        countDownLatch.countDown();
                    }
                });
            }
        countDownLatch.await();

        System.out.println("asdasd");


    }
}
