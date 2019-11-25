package com.example.demo.util.studyThread.java多线程编程核心技术.第二章.t2;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-07 15:41
 **/
public class HasSelfPrivateNum {
    private int num = 0;

    /**
     * 如果不加synchronized 则会出现 实例变量非线程安全，多个线程共同访问num而导致的数据错误
     * @param username
     */
    public synchronized void addI(String username) {
        try {
            if ("a".equals(username)) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(1500);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA aThread = new ThreadA(numRef);
        ThreadB bThread = new ThreadB(numRef);
        aThread.start();
        bThread.start();
    }
}

