package com.example.demo.util.StudyJDK;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2019-09-30 14:36
 **/
public class StringBufferTest {
    public static void main(String[] args) throws InterruptedException {

//        StringBuffer的insert有的方法没有加锁，是在父类里面将参数转换成String，再调用子类的insert(int,String)方法。这个方法是加了锁的
        StringBuffer sb = new StringBuffer("youyi");
        // StringBuffer 代字符串的构造方法，构造的容量是 len+16
        System.out.println("sb.capacity="+sb.capacity());
        System.out.println("sb.length="+sb.length());
        sb.setLength(10);
        System.out.println(sb);
        System.out.println("=========");
        int[] count = {0};
        for (int i=1;i<10;i++) {
            new Thread(()->{
                count[0]+=1;
                sb.insert(count[0],count[0]);
                System.out.println(sb.toString());
            }).start();
        }

        System.out.println(sb.toString());

        Thread.sleep(1000);
        System.out.println("=====================");



    }
}
