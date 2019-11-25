package com.example.demo.util.StudyJDK.overrideTest.clazz;

/**
 * @program: demo
 * @description: description 父类重写clone 模拟
 * AbstractMap
 * @author: youyi
 * @create: 2019-10-14 21:10
 **/
public abstract class AbstractClass {
    protected AbstractClass(){}
    protected Object clone(){
        System.out.println("父类的function");
        return null;
    }
}
