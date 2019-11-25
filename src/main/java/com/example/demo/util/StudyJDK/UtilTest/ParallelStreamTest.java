package com.example.demo.util.StudyJDK.UtilTest;

import java.util.Arrays;
import java.util.List;

/**
 * @program: demo
 * @description:  并行流 测试
 * @author: youyi
 * @create: 2019-10-14 11:30
 **/
public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(num -> {
            /**
             * parallelStream提供了流的并行处理，它是Stream的另一重要特性，
             * 其底层使用Fork/Join框架实现。简单理解就是多线程异步任务的一种实现
             */

            System.out.println(Thread.currentThread().getName() + ">>" + num);
        });

    }
}
