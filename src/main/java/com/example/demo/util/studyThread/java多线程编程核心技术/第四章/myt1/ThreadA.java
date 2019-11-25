package com.example.demo.util.studyThread.java多线程编程核心技术.第四章.myt1;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-12 14:37
 **/
public class ThreadA extends Thread{
    private Context context;
    public ThreadA(Context context){
        super();
        this.context = context;
    }
    @Override
    public void run(){
        context.await();
    }
}
