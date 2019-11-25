package com.example.demo.util.studyThread.java多线程编程核心技术.第二章.myt1;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2019-11-08 16:06
 **/
public class MyThread extends Thread {
    private  Fun fun;
    MyThread(Fun fun) {
        this.fun = fun;
    }
    @Override
    public void run(){
        try {
           fun.synchronizedTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Fun fun =  new Fun();
        // 两个线程操作同一个对象
        MyThread a = new MyThread(fun);
        MyThread b = new MyThread(fun);
        a.start();
        b.start();

    }
}
