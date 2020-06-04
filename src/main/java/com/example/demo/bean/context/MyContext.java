package com.example.demo.bean.context;
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

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: demo
 * @description: 学习ApplicationContext
 *
 * 自定义上下文
 *
 * @author: youyi
 * @create: 2020-04-28 15:53
 **/
public class MyContext extends ClassPathXmlApplicationContext {

    public MyContext(String... config) {
        super(config);

    }

    @Override
    protected void initPropertySources() {
        // For subclasses: do nothing by default.
        // 必须要有的一些环境变量
        // 如果没有就报错
        getEnvironment().setRequiredProperties("VAR");
    }

}
