package com.example.demo.util.studyThread.java多线程编程核心技术.第三章.myt2;

/**
 * @program: demo
 * @description: 消费者
 * @author: youyi
 * @create: 2019-11-11 14:45
 **/
public class Consumer extends Thread{
    private Context context;

    public Consumer(Context entity){
        this.context = entity;
    }
    @Override
    public void run(){
        try {
            while (true){
                context.get();
//                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
