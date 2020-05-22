package com.example.demo.util.StudyJDK.reflect;
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

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: demo
 * @description: 反射！！！！！
 * @author: youyi
 * @create: 2020-05-22 17:46
 **/
public class DoTest {

    public static void main(String[] args) {
        fun(new AObject());
    }

    public static void fun(Object o){
        Class clazz = o.getClass();

        try {
            Field field = clazz.getDeclaredField("name");

            // 设置private是否可达
            field.setAccessible(true);
            Method[] methods = clazz.getMethods();

            AObject b = (AObject) clazz.newInstance();
            b.setName("hh");
            field.set(b,"xixi");
            System.out.println(b);
            for (Method m : methods){
                if (m.getName()=="func"){
                    m.invoke(b,"ada");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
