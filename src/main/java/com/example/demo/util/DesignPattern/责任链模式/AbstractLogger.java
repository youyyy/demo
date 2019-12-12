package com.example.demo.util.DesignPattern.责任链模式;

/**
 * @program: demo
 * @description: 抽象记录类
 * @author: youyi
 * @create: 2019-12-09 14:18
 **/
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        // 总览判断每个节点能做啥
        if(this.level <= level){
            write(message);
        }
        if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);

}
