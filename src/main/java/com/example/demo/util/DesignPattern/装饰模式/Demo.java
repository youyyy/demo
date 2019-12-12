package com.example.demo.util.DesignPattern.装饰模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-08 17:56
 **/
public class Demo {
    public static void main(String[] args) {
        Hero victor = new Victor();
        Skin skin = new Skin1(victor);
        skin.init();

    }
}
