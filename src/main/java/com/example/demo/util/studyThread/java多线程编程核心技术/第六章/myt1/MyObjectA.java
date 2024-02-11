package com.example.demo.util.studyThread.java多线程编程核心技术.第六章.myt1;

/**
 * @program: demo
 * @description: 单例模式 懒汉模式
 *
 * @author: youyi
 * @create: 2019-11-13 20:06
 **/
public class MyObjectA {
    private volatile static MyObjectA object;

    private MyObjectA(){

    }

    public static MyObjectA getInstance1() {
        if (null == object) {// 线程不安全
            object = new MyObjectA();
        }
        return object;
    }
    public static MyObjectA getInstance2() {
        if (null == object) {// 没在锁里面，线程不安全
            synchronized (MyObject.class) {
                object = new MyObjectA();
            }
        }
        return object;
    }
    public static MyObjectA getInstance3() {
        synchronized (MyObject.class) { // 效率太低
            if (null == object) {
                object = new MyObjectA();
            }
        }
        return object;
    }
    public static MyObjectA getInstance4() {
        // Double Check Locking   双重校验
        if (null == object) {
            synchronized (MyObject.class) {
                if (null == object) {
                    object = new MyObjectA();
                }
            }
        }
        return object;
    }
}
