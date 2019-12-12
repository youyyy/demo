package com.example.demo.util.DesignPattern.桥接模式;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-08 16:56
 **/
public class ClientService1 extends Abstraction {
    public ClientService1(Implementation implementation) {
        super(implementation);
    }

    public void serviceA(){
        service1();
    }
}
