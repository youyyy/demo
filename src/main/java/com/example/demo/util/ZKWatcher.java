package com.example.demo.util;/*
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


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.WatchedEvent;

import java.util.List;

/**
 * @program: demo
 * @description: zookeeper客户端:后续考虑可以用来提供接口拉zk数据节点Znode
 *
 * 去掉guava
 *
 * @author: youyi
 * @create: 2020/9/3
 **/
public class ZKWatcher {

    public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new RetryNTimes(10, 5000));
        client.start();
        try {
            List<String> c = client.getChildren().usingWatcher(new CuratorWatcher() {
                @Override
                public void process(WatchedEvent watchedEvent) throws Exception {
                    System.out.println("watchedEvent="+watchedEvent);
                }
            }).forPath("/");
            System.out.println(c);
            // 创建节点
            String result = client.create().forPath("/test", "Data".getBytes());
            System.out.println(result);
            // 设置节点数据
            client.setData().forPath("/test", "111".getBytes());
            client.setData().forPath("/test", "222".getBytes());
            // 删除节点
            System.out.println(client.checkExists().forPath("/test"));
            client.delete().withVersion(-1).forPath("/test");
            System.out.println(client.checkExists().forPath("/test"));
            client.close();
            System.out.println("OK！");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
