package com.example.demo.util.studyThread.java多线程编程核心技术.第三章.myt1;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-10 17:46
 **/
public class NotifyThread extends Thread {
    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.synNotifyMethod(lock);
    }
}

