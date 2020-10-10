package com.example.demo.util.zk;/*
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

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @program: demo
 * @description: zk api 实现watcher
 * @author: youyi
 * @create: 2020/9/27
 **/
public class MyZkWatcherClient implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Enter the process method,the event is :"+watchedEvent);
        Event.EventType type = watchedEvent.getType();
        switch (type) {
            case NodeCreated:
                System.out.println("新建节点:" + watchedEvent.getPath());
            default:
        }
    }
}
