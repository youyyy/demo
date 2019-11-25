package com.example.demo.util.studyThread.java多线程编程核心技术.第一章;

/**
 * @program: demo
 * @description:   异常法终止线程
 * @author: youyi
 * @create: 2019-11-06 19:16
 **/
public class Thread3 extends Thread {
    @Override
    public void run(){
        try{
            for (int i = 0;i<5000000;i++) {
                System.out.println("i="+(i+1));
//                if (this.isInterrupted()) {
//                    System.out.println("已经是终止状态 我要要终止啦");
//                    break;
//                }
                // 不清除终止状态
                if (this.isInterrupted()) {
                    System.out.println("已经是终止状态 我要要抛异常来终止啦");
                    throw new InterruptedException();
                }
            }
            System.out.println("嘿嘿嘿，如果你看到我，那就没有终止");
        }catch ( InterruptedException e) {
            System.out.println("catch");
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        try {
            Thread3  thread = new Thread3();
            thread.start();
            Thread.sleep(2000);
            // 中断线程（只是给线程预设一个标记，不是立即让线程停下来）
            thread.interrupt();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
