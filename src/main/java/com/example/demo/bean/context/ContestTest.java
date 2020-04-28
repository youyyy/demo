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

import com.example.demo.bean.aware.Hello;
import org.springframework.context.ApplicationContext;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-04-28 15:57
 **/
public class ContestTest {
    public static void main(String[] args) {

        ApplicationContext context = new MyContext("classpath:xml/Hello.xml");
        Hello hello = (Hello) context.getBean("hello");
    }
}
