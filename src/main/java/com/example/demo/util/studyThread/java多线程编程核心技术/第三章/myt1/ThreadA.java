package com.example.demo.util.studyThread.java多线程编程核心技术.第三章.myt1;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-10 17:44
 **/
public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.testMethod(lock);
    }
}

