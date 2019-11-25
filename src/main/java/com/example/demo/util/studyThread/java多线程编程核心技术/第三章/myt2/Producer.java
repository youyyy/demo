package com.example.demo.util.studyThread.java多线程编程核心技术.第三章.myt2;

/**
 * @program: demo
 * @description: 生产者
 * @author: youyi
 * @create: 2019-11-11 14:32
 **/
public class Producer extends Thread{
    private Context context;

    public Producer(Context entity){
        this.context = entity;
    }
    @Override
    public void run(){
        try {
            while (true){
                context.set("set"+System.currentTimeMillis());
//                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
