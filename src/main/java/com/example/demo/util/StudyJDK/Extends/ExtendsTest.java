package com.example.demo.util.StudyJDK.Extends;

/**
 * @program: demo
 * @description:  继承测试抽象类！！！
 * 这个类是用来测试AbstractStringBuilder和StringBuffer之间   insert(int,boolean) 方法是否线程安全的测试用例
 * @author: youyi
 * @create: 2019-09-30 17:04
 **/
public class ExtendsTest extends AbstractExtends {
    ExtendsTest() {
    }

    String test1(){
        return super.testParebt();
    }
    @Override
    String doing() {
        return "这个方法是子类返回的！";
    }

    public static void main(String[] args) {
        ExtendsTest E = new ExtendsTest();
        System.out.println(E.test1());

    }
}
