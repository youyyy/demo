package com.example.demo.util.DesignPattern.装饰模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-08 17:48
 **/
public class Skin implements Hero {
    protected Hero hero;
    public Skin(Hero hero){
        this.hero = hero;
    }
    @Override
    public void init() {
        hero.init();
    }
}
