package com.example.demo.util.StudyJDK.Extends;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-09-30 17:05
 **/
public abstract class AbstractExtends {
    AbstractExtends() {
    }

    String testParebt() {
        return doing();
    }

    String doing() {
        return "这个方法是父类返回的！";
    }
}
