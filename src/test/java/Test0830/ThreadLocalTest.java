package Test0830;/*
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

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;

/**
 * @program: demo
 * @description: TheadLocal内存泄漏case
 * @author: youyi
 * @create: 2021/9/1
 **/
public class ThreadLocalTest {
    private static final ThreadLocal<String> a = ThreadLocal.withInitial(()->"1");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor =  new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        executor.submit(new Task());
        Thread.sleep(1000L);
        System.gc();
        Thread.sleep(1000L);
        executor.submit(new Task());
        System.out.println(Thread.currentThread().getName()+"？"+a.get());


    }

    public static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"？"+a.get());
            a.set("youyi");
            System.out.println(Thread.currentThread().getName()+"？"+a.get());
        }
    }
}
