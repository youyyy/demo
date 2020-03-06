package com.example.demo.springDemoTest;
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

import com.example.demo.DemoApplicationTests;
import com.example.demo.util.springDemo.AService;
import com.example.demo.util.springDemo.Event.Entity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-03-06 19:13
 **/
public class Start extends DemoApplicationTests {
    @Autowired
    private AService service;

    /**
     * 事件监听
     */
    @Test
    public void fun(){
        Entity entity = new Entity();
        entity.setId(1);
        entity.setName("youyi");
        Entity entity2 = new Entity();
        entity2.setId(2);
        entity2.setName("xiaoyou");
        service.execute(entity);
        service.execute(entity2);
    }
}
