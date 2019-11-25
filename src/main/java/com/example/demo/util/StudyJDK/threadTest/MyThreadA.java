package com.example.demo.util.StudyJDK.threadTest;

/**
 * @program: demo
 * @description: description 继承Thread类 重写run方法
 * @author: youyi
 * @create: 2019-10-08 09:50
 **/
public class MyThreadA extends Thread {
    MyThreadA(String name){
        this.setName(name);
    }
    @Override
    public void run(){
        System.out.println("我是线程"+this.getName()+"，优先级为="+currentThread().getPriority());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadA threadA = new MyThreadA("youyi");
        MyThreadA threadA1 = new MyThreadA("22222");
        System.out.println("我是线程"+currentThread().getName()+"，优先级为="+currentThread().getPriority());
        threadA.start();
        threadA.join();
        System.out.println("我是线程"+currentThread().getName()+"，优先级为="+currentThread().getPriority());
        Thread.sleep(2000);
        threadA1.start();

    }
}
