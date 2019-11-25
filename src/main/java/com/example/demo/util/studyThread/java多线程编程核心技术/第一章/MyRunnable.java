package com.example.demo.util.studyThread.java多线程编程核心技术.第一章;

/**
 * @program: demo
 * @description: 实现Runnable接口
 * @author: youyi
 * @create: 2019-11-06 16:12
 **/
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("线程运行中");
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("end");
    }
}
