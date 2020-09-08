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

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2020/9/7
 **/
public class Doo {
    public static void main(String args[]) {
        new Doo().testAnother();
    }

    private void test1(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(DoTestFun.class);
        enhancer.setCallback(new MyMethodInterceptor());
        DoTestFun targetObject2=(DoTestFun)enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(200));
    }

    private void testAnother(){
        AnotherProxy proxy = new AnotherProxy();
        MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();

        Enhancer enhancer =new Enhancer();
        enhancer.setClassLoader(DoTestFun.class.getClassLoader());
        enhancer.setSuperclass(DoTestFun.class);
        enhancer.setCallbacks(new Callback[] {myMethodInterceptor,proxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new AotherFilter());

        DoTestFun targetObject2=(DoTestFun)enhancer.create();
//        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(200));
    }
}
