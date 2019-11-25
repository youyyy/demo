package com.example.demo.util.studyThread.java多线程编程核心技术.第三章.myt2;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 上下文
 * @author: youyi
 * @create: 2019-11-11 14:33
 **/
public class Context {
    private LinkedList<String> list ;
    public Context(LinkedList list){
        this.list = list;
    }
    public void set(String value) throws InterruptedException {
        synchronized(list) {
            while(list.size()>5) {
                list.wait();
            }
            list.offer(value);
            System.out.println("push"+value+";size="+list.size());
            list.notifyAll();
        }
    }
    public void get() throws InterruptedException {
        synchronized(list) {
            while(list.size()<1) {
                list.wait();
            }
            System.out.println("删除"+list.pop()+"size="+list.size());
            list.notifyAll();
        }
    }

}
