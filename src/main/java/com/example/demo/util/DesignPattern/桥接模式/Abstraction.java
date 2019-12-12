package com.example.demo.util.DesignPattern.桥接模式;

/**
 * @program: demo
 * @description: 如果一个类存在两个维度，且两个维度都常变化扩展
 * @author: youyi
 * @create: 2019-12-08 16:50
 **/
public abstract class Abstraction {
    private Implementation implementation;

    public Abstraction(Implementation implementation) {
        this.implementation = implementation;
    }

    public void service1(){
        implementation.facility1();
    }

    protected Implementation getImplementation(){
        return implementation;
    }
}
