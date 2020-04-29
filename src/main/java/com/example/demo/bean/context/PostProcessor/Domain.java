package com.example.demo.bean.context.PostProcessor;
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

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-04-29 14:42
 **/
public class Domain {
    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory =
                new XmlBeanFactory(new ClassPathResource("/xml/BeanFactoryPostProcessor.xml"));
        // 后处理器
        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) beanFactory.getBean("bfpp");
        bfpp.postProcessBeanFactory(beanFactory);
        System.out.println(beanFactory.getBean("simpleBean"));
    }
}
