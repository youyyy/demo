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

import com.example.demo.util.springDemo.Event.Entity;
import com.example.demo.util.springDemo.Event.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2020-03-06 18:02
 **/
@Component
public class AService{
    /**
     * 定义Spring上下文对象
     */
    @Autowired
    private ApplicationContext applicationContext;

//             implement ApplicationContextAware
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
    public void execute(Entity entity) {
        // 1.构造一个增加学生的事件
        UserEvent userEvent = new UserEvent(entity.getName(),entity);
        // 2.触发增加学生事件
        applicationContext.publishEvent(userEvent);
    }
}
