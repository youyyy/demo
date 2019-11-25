package com.example.demo.util.StudyJDK;

/**
 * @program: demo
 * @description: 字符序列的抽象实现，是StringBuilder和StringBuffer的父类
 * @author: youyi
 * @create: 2019-09-29 20:48
 **/
public class AbstractStringBuilderTest {
    // 因为AbstractStringBuilder不能实例化，所以用StringBuilder来实现测试

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // 初始长度为16
        sb.ensureCapacity(12);
        System.out.println("sb.length="+sb.length());
        System.out.println("sb.capacity"+sb.capacity());

        // 扩充容量  非线程安全  StringBuffer的是线程安全的
        sb.ensureCapacity(24);
        System.out.println("sb.length="+sb.length());
        System.out.println("sb.capacity="+sb.capacity());

        System.out.println("=====================");
        // 下面比较setLength和ensureCapacity的区别
        StringBuilder sb2 = new StringBuilder();
        sb.setLength(12);
        System.out.println("sb2.length="+sb2.length());
        System.out.println("sb2.capacity="+sb2.capacity());


        sb2.setLength(24);
        System.out.println("sb2.length="+sb2.length());
        System.out.println("sb2.capacity="+sb2.capacity());


    }
}
