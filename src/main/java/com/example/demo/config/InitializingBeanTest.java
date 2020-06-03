package com.example.demo.config;
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

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * InitializingBean接口为bean提供了属性初始化后的处理方法
 * 后处理 设置完属性后调用 在AbstractAutowireCapableBeanFactory的invokeInitMethods函数
 *
 * 通常情況下我不鼓勵bean直接實現InitializingBean，可以使用Spring提供的init-method的功能來執行一個bean子定義的初始化方法
 * @author: youyi
 * @create: 2020-06-02 20:09
 **/
@Component
public class InitializingBeanTest implements InitializingBean {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void init(){
        System.out.println("youyi-init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("youyi-afterPropertiesSet");
    }
}
