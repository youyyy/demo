package com.example.demo.util.StudyJDK.ThreadPoolExcutor;/*
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

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2020/9/9
 **/
@Slf4j
public class ThreadExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new IoThreadPoolExecutor(3, 3, 60L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(16), Executors.defaultThreadFactory(),new RejectedPolicyWithReport());

        Callable callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return Thread.currentThread().getName()+"______"+System.currentTimeMillis();
            }
        };
        for (int i = 0; i < 50; i++) {
            Future a = executor.submit(callable);
//            try {
//                log.info("log-info ==============");
//                System.out.println(a.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }


    }
}
