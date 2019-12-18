package com.example.demo.util.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @program: demo
 * @description: 直接内存溢出 对jdk1.8 没有实现出来
 *
 * -Xmx2M -XX:MaxDirectMemorySize=1M -verbose:gc
 *
 * @author: youyi
 * @create: 2019-12-12 16:42
 **/
public class DirectMemoryOOM {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
