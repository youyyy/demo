package com.example.demo.util.DesignPattern.责任链模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-09 14:19
 **/
public class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
