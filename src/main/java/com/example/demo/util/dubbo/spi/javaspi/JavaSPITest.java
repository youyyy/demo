package com.example.demo.util.dubbo.spi.javaspi;
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

import java.util.ServiceLoader;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-05-18 19:04
 **/
public class JavaSPITest {
    public static void main(String[] args) throws Exception {
        new JavaSPITest().sayHello();
    }
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
