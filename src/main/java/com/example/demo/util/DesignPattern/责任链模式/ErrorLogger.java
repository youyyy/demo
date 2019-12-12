package com.example.demo.util.DesignPattern.责任链模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-09 14:20
 **/
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
