package com.example.demo.lang.classLoader;/*
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

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: demo
 * @description: 自定义类加载器
 * @author: youyi
 * @create: 2021/9/7
 **/
public class CustomizeClassLoaderTest{

    public static void main(String[] args) throws Exception {
        String currentClass = "com.example.demo.lang.classLoader.CustomizeClassLoaderTest";
        // 1
        ClassLoader clazzLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException{
                try {
                    String clazzName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(clazzName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }

        };

        // 2
        Class<?> clazz = clazzLoader.loadClass(currentClass);
        Object obj = clazz.newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.example.demo.lang.classLoader.CustomizeClassLoaderTest);
    }
}
