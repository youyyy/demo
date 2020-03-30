package com.example.demo.util.springtest;
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

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: demo
 * @description: spring 加载资源文件
 * @author: youyi
 * @create: 2020-03-30 17:27
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        Resource resource = new ClassPathResource("word.properties");
        InputStream inputStream = resource.getInputStream();

        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("message"));
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("/xml/Beans.xml"));

        System.out.println(factory.getBean("word"));
    }
}
