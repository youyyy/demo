package com.example.demo.aop.myaop;
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
 * @create: 2020-04-30 14:39
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("=========add============");
    }
}
