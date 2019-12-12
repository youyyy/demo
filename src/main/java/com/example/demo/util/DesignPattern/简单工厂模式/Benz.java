package com.example.demo.util.DesignPattern.简单工厂模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-08 15:02
 **/
public class Benz implements Car {
    @Override
    public void drive() {
        System.out.println("开奔驰");
    }
}
