package com.example.demo.util.studyThread.java多线程编程核心技术.第四章.myt2;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2019-11-12 15:18
 **/
public class Server {
    public static void main(String[] args) {
        Context context = new Context();
        new Thread(()->{
            int i = 0;
            do {
                context.add("add"+i);
                i++;
            }while (i<1000);
        }).start();

        new Thread(()->{
            int i = 0;
            do {
                context.remove();
                i++;
            }while (i<500);
        }).start();
        new Thread(()->{
            int i = 0;
            do {
                context.remove();
                i++;
            }while (i<500);
        }).start();
    }
}
