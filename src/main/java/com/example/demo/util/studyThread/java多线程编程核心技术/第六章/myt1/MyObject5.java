package com.example.demo.util.studyThread.java多线程编程核心技术.第六章.myt1;

import java.sql.Connection;

/**
 * @program: demo
 * @description: 利用枚举实现 单例模式
 * @author: youyi
 * @create: 2019-11-13 21:07
 **/

public class MyObject5 {
    // 内部枚举
    public enum Singleton {
        objectFactory;
        private MyObject5 object;
        private Singleton(){
            object = new MyObject5();
        }

        public MyObject5 getObject() {
            return object;
        }
    }

    public static MyObject5 getInstance(){
        return Singleton.objectFactory.getObject();
    }
}
