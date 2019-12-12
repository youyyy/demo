package com.example.demo.bean.DI;


/**
 * @program: demo
 * @description: 基础容器注入，运用BeanFactory
 * @author: youyi
 * @create: 2019-12-11 11:03
 **/
public class HelloWord {
    private String message = "hehe";

    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
