package com.example.demo.util.studyThread.java多线程编程核心技术.第五章.myt1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: demo
 * @description:   定时任务   TimerTask   抽象类必须重写
 * @author: youyi
 * @create: 2019-11-13 16:18
 **/
public class MyTask extends TimerTask{
    private static  Timer time = new Timer(true);
    @Override
    public void run() {
        System.out.println("now="+new Date());
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        System.out.println("main-now"+new Date());

        time.schedule(task,new Date());
    }
}
