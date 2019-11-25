package com.example.demo.util.studyThread.java多线程编程核心技术.第一章;

/**
 * @program: demo
 * @description: 测试停止线程   interrupt  并不是真正的停止，只是做了一个标记
 * @author: youyi
 * @create: 2019-11-06 18:02
 **/
public class Thread2 extends Thread {
    @Override
    public void run(){
        for (int i = 0;i<500000;i++) {
            System.out.println("i="+(i+1));
        }
    }

    public static void main(String[] args) {
        try {
            Thread2  thread = new Thread2();
            thread.start();
            Thread.sleep(2000);
            // 中断线程（只是给线程预设一个标记，不是立即让线程停下来）
            thread.interrupt();

            // （非静态）测试线程是否已经中断，线程的中断状态不受影响
            System.out.println("是否停止1？=" + thread.isInterrupted());
            System.out.println("是否停止2？=" + thread.isInterrupted());


//            Thread.currentThread().interrupt();
            // （静态）测试当前线程是否已经中断，线程的中断状态会被清除
//            System.out.println("是否停止主线程111？=" + Thread.interrupted());
//            System.out.println("是否停止主线程222？=" + Thread.interrupted());

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
