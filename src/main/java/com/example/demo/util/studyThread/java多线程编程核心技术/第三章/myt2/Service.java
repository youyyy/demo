package com.example.demo.util.studyThread.java多线程编程核心技术.第三章.myt2;

import java.util.LinkedList;

/**
 * @program: demo
 * @description: 测试生产者消费者模式
 * @author: youyi
 * @create: 2019-11-11 14:46
 **/
public class Service {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Context context = new Context(linkedList);

        Producer producer = new Producer(context);


        Consumer consumer = new Consumer(context);



        producer.start();
        consumer.start();

    }
}
