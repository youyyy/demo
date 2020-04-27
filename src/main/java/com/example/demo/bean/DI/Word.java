package com.example.demo.bean.DI;

/**
 * @program: demo
 * @description: xml配置方法注入
 * @author: youyi
 * @create: 2019-12-11 12:12
 **/
public class Word {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }
    public void  initTest(){
        System.out.println("init: " + message);

    }
    public void getMessage(){
        System.out.println("Your word : " + message);
    }
}
