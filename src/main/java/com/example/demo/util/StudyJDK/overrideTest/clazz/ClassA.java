package com.example.demo.util.StudyJDK.overrideTest.clazz;


/**
 * @program: demo
 * @description: description 模拟HashMap重写clone
 * @author: youyi
 * @create: 2019-10-14 21:11
 **/
public class ClassA extends AbstractClass implements Cloneable{
    @Override
    public Object clone(){
        System.out.println("子类的function");
        return null;
    }

    public static void main(String[] args) {
        AbstractClass parent = new ClassA();

        parent.clone();
    }
}
