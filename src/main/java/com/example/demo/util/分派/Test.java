package com.example.demo.util.分派;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-10 10:51
 **/
public class Test {
    public void dost(Father f,Father f1){
        System.out.println("ff");
    }
    public void dost(Father f,Son s){
        System.out.println("fs");
    }
    public void dost(Son s,Father f1){
        System.out.println("sf");
    }
    public void dost(Son s,Son s1){
        System.out.println("ss");
    }

    public static void main(String[] args) {
        Father f = new Father();
        Father son = new Son();
        System.out.println("son instanceof son"+(son instanceof Son));
        System.out.println("son instanceof father"+(son instanceof Father));

        Test t = new Test();

        t.dost(f,new Father());
        t.dost(f,son);

        t.dost(son,f);

        t.dost(son,new Son());


        son.say();

    }
}
