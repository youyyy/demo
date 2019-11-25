package com.example.demo.util.studyThread.java多线程编程核心技术.第六章.myt1;

/**
 * @program: demo
 * @description: 饿汉模式
 * @author: youyi
 * @create: 2019-11-13 20:59
 **/
public class MyObject {
    private static MyObject object = new MyObject();

    public MyObject(){}

    public static MyObject getInstance(){
        return object;
    }
}