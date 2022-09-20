package com.example.demo.util.guava;/*
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

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @program: demo
 * @description: 测试线程池的guava用法
 * @author: youyi
 * @create: 2021/9/3
 **/
public class InvokeTest {
    private static final ExecutorService threadPoolExecutor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("[youyi]").build(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        InvokeTest test = new InvokeTest();
        test.test1();
        test.test2();

    }



    private void test1() {
        System.out.println("======1========");
        List<String> strings = Arrays.asList("1", "2", "3");
        List<ListenableFuture<String>> collect = strings.stream().map(e -> Futures.submit(() -> {
            System.out.println(e);
            return e + 1;
        }, threadPoolExecutor)).collect(Collectors.toList());

        try {
            List<String> strings1 = Futures.allAsList(collect).get();
            strings1.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======1========");
    }




    private static Callable apply(String e) {
        return () -> {
            System.out.println(e);
            return e + 1;
        };
    }
    public void test2() {
        System.out.println("======2========");
        List<String> strings = Arrays.asList("1", "2", "3");


        List collect = strings.stream().map(InvokeTest::apply).collect(Collectors.toList());

        try {
            List<Future<Object>> futures = threadPoolExecutor.invokeAll(collect);
            List<Object> collect1 = futures.stream().map(e -> {
                try {
                    return e.get();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // 允许部分失败
                return null;
            }).collect(Collectors.toList());
            collect1.forEach(System.out::println);
            System.out.println("======2========");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
