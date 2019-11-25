package com.example.demo.util.studyThread.java多线程编程核心技术.第六章.myt1;

/**
 * @program: demo
 * @description: static代码块实现  单例模式
 * @author: youyi
 * @create: 2019-11-13 20:57
 **/
public class MyObject4 {
    private static MyObject4 instance = null;

    public MyObject4() {

    }

    static {
        instance = new MyObject4();
    }

    public static MyObject4 getInstance() {
        return instance;
    }
}
