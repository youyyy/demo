package com.example.demo.util.studyThread.Java并发编程的艺术.第三章.mt1;

/**
 * @program: demo
 * @description: 测试final域的重排序
 * @author: youyi
 * @create: 2019-11-26 17:15
 **/
public class FinalExample{
    int i;
    final int j;
    static FinalExample obj;
    public FinalExample(){
        i = 1;
        j = 2;
    }
    public static void writer() throws InterruptedException {
        Thread.sleep(1000);
        obj = new FinalExample();
    }
    public static void reader(){
        FinalExample object = obj;
        System.out.println(obj.i+"_"+obj.j);
        int a = object.i;
        int b = object.j;
    }

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    writer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                reader();
            }
        });

        a.start();
        b.start();
    }
}