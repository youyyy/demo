package com.example.demo.bean.aware;
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

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: demo
 * @description: aware用法
 * @author: youyi
 * @create: 2020-04-27 17:28
 **/
public class TestAware implements BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAware() {
        Hello hello = (Hello) beanFactory.getBean("hello");
        hello.say();
    }


    public static void main(String[] args) {
        // 需要写一下
        ApplicationContext ct = new ClassPathXmlApplicationContext("classpath:xml/Hello.xml");
        TestAware testAware = (TestAware) ct.getBean("testAware");
        testAware.testAware();
    }
}
