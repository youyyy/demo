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
 * @description: CyclicBarrier
 * @author: youyi
 * @create: 2021/9/3
 **/
public class CyclicBarrierTest {
    private static final  ExecutorService executor = new ThreadPoolExecutor(6,12,0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(500),
            new ThreadFactoryBuilder().setNameFormat("commonAsync-Thread-%d").build(),
            new ThreadPoolExecutor.CallerRunsPolicy());
    public static void main(String[] args) {
        // 达成后触发，可以重复用
        // 栅栏
        CyclicBarrier lock = new CyclicBarrier(10,()-> System.out.println("10次执行完了"));

        for (int i = 0; i < 10; i++) {
            int finalI1 = i;
            executor.submit(()->{
                System.out.println("before"+ finalI1);
                try {
                    lock.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("第三优先");
            });

        }
    }
}
