package com.example.demo.util.studyThread.java多线程编程核心技术.第二章.t2;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-07 15:42
 **/
public class ThreadA extends Thread{
    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
