package com.example.demo.bean.DI;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-31 14:51
 **/
public class XixiWord {

    private String message;

    public XixiWord(String message) {
        this.message = message;
    }

    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your word : " + message);
    }
}
