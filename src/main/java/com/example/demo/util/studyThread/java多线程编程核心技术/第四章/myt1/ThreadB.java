package com.example.demo.util.studyThread.java多线程编程核心技术.第四章.myt1;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-12 14:40
 **/
public class ThreadB extends Thread{
    private Context context;
    public ThreadB(Context context){
        super();
        this.context = context;
    }
    @Override
    public void run(){
        context.signal();
    }
}
