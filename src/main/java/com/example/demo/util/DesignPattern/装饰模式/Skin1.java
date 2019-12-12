package com.example.demo.util.DesignPattern.装饰模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-08 17:51
 **/
public class Skin1 extends Skin {

    public Skin1(Hero hero) {
        super(hero);
    }

    @Override
    public void init(){
        super.init();
        setSkin();
    }
    private void setSkin(){
        System.out.println("皮肤:银河战士套装");
    }

}
