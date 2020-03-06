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
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 事件监听用法
 * @author: youyi
 * @create: 2020-03-06 19:27
 **/
@Component
public class EventListener2 {
    @EventListener(classes = UserEvent.class,condition = "#event.entity.id==1")
    @Order(1)
    @Async
    public void fun(UserEvent event){
        System.out.println("listener2+  "+event.getEntity());
        event.getEntity().setName("modify");
    }

    @EventListener(classes = UserEvent.class,condition = "#event.entity.id==1")
    @Order(2)
    @Async
    public void fun2(UserEvent event){
        System.out.println("listener3+  "+event.getEntity());
    }
}
