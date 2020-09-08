package com.example.demo.util.cglib;/*
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

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2020/9/7
 **/
public class AotherFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("method1".equals(method.getName())) {
            return 0;
        }
        return 1;
    }
}
