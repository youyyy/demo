package com.example.demo.util.DesignPattern.装饰模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-08 17:48
 **/
public class Victor implements Hero {
    @Override
    public void init() {
        System.out.println("维克托：输出型英雄 武器：步枪");
    }
}
