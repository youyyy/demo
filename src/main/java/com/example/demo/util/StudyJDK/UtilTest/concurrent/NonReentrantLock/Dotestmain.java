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
 * @description:
 * @author: youyi
 * @create: 2020/9/9
 **/
@Slf4j
public class Dotestmain {
    private static Lock lock = new Lock();

    public static void main(String[] args) {
        Runnable a = new Runnable() {
            @Override
            public void run() {
            try {
                lock.lock();
                System.out.println("1");
                lock.lock();
                System.out.println("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            }
        };
        new Thread(a).start();

    }
}
