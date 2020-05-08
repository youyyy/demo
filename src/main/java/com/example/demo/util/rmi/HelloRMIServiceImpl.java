package com.example.demo.util.rmi;
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

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-05-08 16:45
 **/
public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int getAdd(int a, int b) {
        return a+b;
    }
}
