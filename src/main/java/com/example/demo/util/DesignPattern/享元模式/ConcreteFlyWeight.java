package com.example.demo.util.DesignPattern.享元模式;

/**
 * @program: demo
 * @description: 具体享元类
 * @author: youyi
 * @create: 2019-12-09 10:26
 **/
public class ConcreteFlyWeight implements FlyWeight{
    /**内部状态*/
    private String intrinsicState;

    /**
     * 构造方法，并设置内部状态.
     * @param intrinsicState
     */
    public  ConcreteFlyWeight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("内部状态：" + intrinsicState);
        System.out.println("外部状态：" + extrinsicState);
    }
}
