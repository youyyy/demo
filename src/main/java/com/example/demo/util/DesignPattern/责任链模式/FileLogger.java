package com.example.demo.util.DesignPattern.责任链模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-09 14:21
 **/
public class FileLogger extends AbstractLogger{
    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
