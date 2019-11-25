package com.example.demo.util.studyThread.java多线程编程核心技术.第六章.myt1;

/**
 * @program: demo
 * @description: 静态内部类
 * @author: youyi
 * @create: 2019-11-13 20:48
 **/
public class MyObject3 {
    private MyObject3(){

    }

    private static class Instance{
        private static MyObject3 object = new MyObject3();
    }
    public static MyObject3 getInstance(){
        return Instance.object;
    }

}
