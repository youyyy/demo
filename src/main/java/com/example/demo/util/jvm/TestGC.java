package com.example.demo.util.jvm;

/**
 * @program: demo
 * @description: 测试GC是不是引用计数法
 *
 * -XX:+PrintGCDetails
 *
 * @author: youyi
 * @create: 2019-12-12 17:29
 **/
public class TestGC {
    private static final int _1MB = 1024*1024;
    // 这个成员的作用是占一点内存，看GC是否清除它
    private byte[] byteSize = new byte[2*_1MB];

    Object obj;

    public void testGC() {
        TestGC a1 = new TestGC();
        TestGC a2 = new TestGC();
        a1.obj = a2;
        a2.obj = a1;
        a1 = null;
        a2 = null;
        System.gc();//如果采用引用记数法则不回收
    }

    public static void main(String[] args) {
        new TestGC().testGC();
    }

}
