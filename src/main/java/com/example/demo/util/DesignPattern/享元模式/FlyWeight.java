package com.example.demo.util.DesignPattern.享元模式;

/**
 * @program: demo
 * @description: 定义享元类接口
 * @author: youyi
 * @create: 2019-12-09 10:25
 **/
public interface FlyWeight {
    /**
     * 操作方法.
     * @param extrinsicState 外部状态
     */
    public void operation(String extrinsicState);
}
