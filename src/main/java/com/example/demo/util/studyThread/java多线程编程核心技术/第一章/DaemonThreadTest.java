package com.example.demo.util.studyThread.java多线程编程核心技术.第一章;

/**
 * @program: demo
 * @description: 守护线程测试
 * @author: youyi
 * @create: 2019-11-07 12:13
 **/
public class DaemonThreadTest extends Thread{
    private int i = 0;

    @Override
    public void run(){
        try {
            while (true) {
                i++;
                System.out.println("i="+i);
                Thread.sleep(1000);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            DaemonThreadTest thread = new DaemonThreadTest();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("嘿嘿，停止了");
            // 父线程完结之后  守护线程理应销毁
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
