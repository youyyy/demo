package com.example.demo.util.studyThread.java多线程编程核心技术.第一章;

/**
 * @program: demo
 * @description: 测试自线程内部的异常处理   不用回调没法在主线程
 * @author: youyi
 * @create: 2019-11-06 19:50
 **/
public class Thread4 extends Thread {

    @Override
    public void run(){
        try {
            System.out.println("刚开始run");
            throw new InterruptedException("就想抛异常");
        }catch (InterruptedException e){
            System.out.println("catch了异常");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try{
            new Thread4().start();
            Thread.sleep(10000);
            System.out.println("主线程不影响");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
