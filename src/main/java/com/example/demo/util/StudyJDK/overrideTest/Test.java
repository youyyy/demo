package com.example.demo.util.StudyJDK.overrideTest;

import com.example.demo.util.StudyJDK.overrideTest.clazz.AbstractClass;
import com.example.demo.util.StudyJDK.overrideTest.clazz.ClassA;

/**
 * @program: demo
 * @description:
 * 复现AbstractMap的clone() 和HashMap的clone()
 *
 * 若是实例化在父类的包里，protected 的方法，还是调用的子类的
 *
 * 若是在父类的包外，因为没法访问父类的protected方法，所以不能调用子类的方法
 *
 * @author: youyi
 * @create: 2019-10-14 21:19
 **/
public class Test {
    public static void main(String[] args) {
        AbstractClass parent = new ClassA();
        // TODO: 2019/10/14 特别重要的一个点  继承和多态
        // 这应该属于编译的问题
//        parent.clone();
    }
}
