package com.example.demo.util.springDemo;
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

import com.example.demo.util.springDemo.Event.UserEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-03-06 18:05
 **/
@Component
public class EventListener implements ApplicationListener<UserEvent> {


    @Override
    public void onApplicationEvent(UserEvent event) {
        System.out.println(event);
    }
}
