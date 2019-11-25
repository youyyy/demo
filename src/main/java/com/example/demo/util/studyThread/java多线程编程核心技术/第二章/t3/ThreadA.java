package com.example.demo.util.studyThread.java多线程编程核心技术.第二章.t3;

import com.example.demo.util.studyThread.java多线程编程核心技术.第二章.t2.HasSelfPrivateNum;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-07 15:42
 **/
public class ThreadA extends Thread{
    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}
