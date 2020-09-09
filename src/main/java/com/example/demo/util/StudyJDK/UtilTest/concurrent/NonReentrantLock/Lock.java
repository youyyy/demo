package com.example.demo.util.StudyJDK.UtilTest.concurrent.NonReentrantLock;/*
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

import lombok.extern.slf4j.Slf4j;

/**
 * @program: demo
 * @description: 不可重入锁例子
 * @author: youyi
 * @create: 2020/9/9
 **/
@Slf4j
public class Lock {
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            log.warn("is waiting for get lock");
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
        log.info("lock is notified");
    }
}
