package com.example.demo.util.studyThread.java多线程编程核心技术.第二章.myt1;

/**
 * @program: demo
 * @description: 测试同步块的执行顺序
 * @author: youyi
 * @create: 2019-11-08 16:06
 **/
public class Fun {
    private int i = 0;
    public void synchronizedTest() throws InterruptedException {
        System.out.println("同步块前"+Thread.currentThread().getName());
        synchronized (this){
            System.out.println("同步块中"+Thread.currentThread().getName()+";i="+i);
            i++;
        }
        Thread.sleep(5000);
        System.out.println("同步块后"+Thread.currentThread().getName());


    }
}
