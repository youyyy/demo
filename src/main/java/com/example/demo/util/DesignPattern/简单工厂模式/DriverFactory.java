package com.example.demo.util.DesignPattern.简单工厂模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-08 15:03
 **/
public class DriverFactory {
    public static Car driveCar(String s) throws Exception{
        if (s.equalsIgnoreCase("Benz")){
            return new Benz();
        }else if (s.equalsIgnoreCase("Bmw")){
            return new Bmw();
        }else {
            throw new Exception();
        }
    }

}
