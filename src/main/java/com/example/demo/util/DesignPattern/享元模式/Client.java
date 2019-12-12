package com.example.demo.util.DesignPattern.享元模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-09 11:25
 **/
public class Client {
    public static void main(String[] args) {
        FlyWeightFactory factory = FlyWeightFactory.getInstance();
        FlyWeight flyWeight1 = factory.getFlyWeight("a");
        FlyWeight flyWeight2 = factory.getFlyWeight("b");
        FlyWeight flyWeight3 = factory.getFlyWeight("a");
        FlyWeight flyWeight4 = factory.getFlyWeight("c");

        //flyWeight1和flyWeight3具有相同的内部状态a,使用同一个实例，下面结果输出true
        System.out.println(flyWeight1 == flyWeight3);

        //不同的外部状态从方法传入
        flyWeight2.operation("hello");
        flyWeight2.operation("hi");
    }
}
