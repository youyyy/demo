package com.example.demo.aop.myaop;
/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: demo
 * @description: 用于对接口提供的方法进行增强
 * @author: youyi
 * @create: 2020-04-30 14:40
 **/
public class MyInvocationHandler implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * 执行目标的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("============before=============");
        Object result = method.invoke(target,args);
        System.out.println("============after=============");
        return result;
    }

    /**
     * 获取目标对象的代理对象
     * @return 代理对象
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        UserService us = new UserServiceImpl();

        MyInvocationHandler invocationHandler = new MyInvocationHandler(us);

        // 代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        proxy.add();;
    }
}
