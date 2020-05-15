package com.example.demo.util.StudyJDK.UtilTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-27 17:22
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();

        linkedList.add("youyi");
        linkedList.add("xiaoyou");

        System.out.println(linkedList.get(1).getClass().equals(String.class));
        test();


        sortLinkedList();
    }
    private static void test(){
        LinkedList<Dog> linkedList = new LinkedList<>();

        linkedList.add(new Dog("wangwang"));
        linkedList.add(new Dog("heihei"));

        linkedList.addFirst(new Dog("haha"));
        linkedList.add(1,new Dog("xixixi"));
        System.out.println(linkedList);

        System.out.println("迭代器[0,n]有空头空尾"+linkedList.listIterator(4).hasPrevious());

        Dog[] list = new Dog[10];
        linkedList.toArray(list);

        // 修改了list[0]的引用 影响不到linkedList
        list[0] = new Dog("狗逼");

        System.out.println(list[0] + "_"+linkedList);

    }
    private static class Dog{
        private String name;

        public Dog() {
        }

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void sortLinkedList(){
        // 子类没实现排序的list用list接口的归并排序
        List<Integer> a = new LinkedList<>();
        a.add(10);
        a.add(1);
        System.out.println(a);
        Collections.sort(a);
        System.out.println(a);
    }
}
