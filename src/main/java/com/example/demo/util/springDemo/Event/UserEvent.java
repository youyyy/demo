package com.example.demo.util.springDemo.Event;
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

import org.springframework.context.ApplicationEvent;

/**
 * @program: demo
 * @description: 事件类
 * @author: youyi
 * @create: 2020-03-06 17:56
 **/
public class UserEvent extends ApplicationEvent {
    private Entity entity;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserEvent(String source) {
        super(source);
    }

    public UserEvent(String source, Entity entity) {
        super(source);
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

}
