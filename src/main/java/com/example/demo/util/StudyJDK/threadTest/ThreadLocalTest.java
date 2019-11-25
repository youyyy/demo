package com.example.demo.util.StudyJDK.threadTest;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-10 11:41
 **/
public class ThreadLocalTest {
    private static final int HASH_INCREMENT = 0x61c88647;

//    public static void main(String[] args) {
//        magicTest();
//    }

    /**
     * ThreadLocal里魔数的测试
     */
    public static void magicTest() {
        int s = 0;
        double n = 4;
        int Max = (int) Math.pow(2, n);

        for (int i = s; i < Max + s; i++) {
            System.out.println(i * HASH_INCREMENT & (Max - 1));
        }
    }
    // ThreadLocal数据以线程为单位进行保存，InheritableThreadLocal的原理是在子线程创建的时候 
    // 将父线程的变量(浅)拷贝到自身中
    // TODO: 2019/10/16 注意这里我尝试过用ThreadLocal获取parent也没办法拿到父线程
//    private ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void test() throws InterruptedException {
        threadLocal.set("parent");

        Thread thread = new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set("child");
            System.out.println(threadLocal.get());
        });

        thread.start();

        thread.join();

        System.out.println(threadLocal.get());
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadLocalTest().test();
    }


}
