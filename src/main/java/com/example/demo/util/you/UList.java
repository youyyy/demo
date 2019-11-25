package com.example.demo.util.you;

import java.util.*;
import java.util.function.UnaryOperator;
/**
 * @Description
 * @Author youyi
 * @Date 2019/9/5 下午5:58
 **/
public class UList {
    private static List<String> list = Collections.synchronizedList(new ArrayList<>());
    private static List<String> list_2 = new ArrayList<>();

    public static void main(String[] args) {

        /**
         * 是用的静态内部类，是线程安全的
         */
        Thread t = new Thread(() -> {
            list.add(String.valueOf(new Random().nextInt()));
            System.out.println(list);
            System.out.println("--------------");
        });
        for (int i = 0; i < 100; i++) {
            new Thread(t).start();
        }


        /**
         * 这里是有问题的，因为ArrayList不是线程安全的
         */
//        Thread t2 = new Thread(()->{
//            list_2.add(String.valueOf(new Random().nextInt()));
//            System.out.println(list_2);
//        });
//        for (int i=0;i<100;i++){
//            new Thread(t2).start();
//        }


        /**
         * 如果初始化没有同步的话，在需要互斥的地方包起来也行，只是对于我们判断是否需要互斥就很麻烦
         */
        Thread t3 = new Thread(() -> {
            synchronized (list_2) {
                list_2.add(String.valueOf(new Random().nextInt()));
                System.out.println(list_2);
            }
        });
        for (int i = 0; i < 100; i++) {
            new Thread(t3).start();
        }


        list.replaceAll(e -> e.substring(1, 4));


        /**
         * sort默认采用mergeSort
         */
        list.sort(String::compareTo);



    }

    void replaceAll() {
        /**
         * 实现replaceAll
         */
        UnaryOperator<String> operator = e -> e + "测试";
        Objects.requireNonNull(operator);
        /**
         * 本身不能修改，但是指向的对象可以修改
         */
        final ListIterator<String> li = list.listIterator();
        while (li.hasNext()) {
            li.set(operator.apply(li.next()));
        }
    }
}
