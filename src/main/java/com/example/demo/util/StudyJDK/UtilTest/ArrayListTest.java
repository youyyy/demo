package com.example.demo.util.StudyJDK.UtilTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: ArrayList测试
 * @author: youyi
 * @create: 2019-10-23 19:49
 **/
public class ArrayListTest {

    // 测试数组拷贝之后是否相等
    public static void isCloneEqualPre(){
        ArrayList<Integer> list = new ArrayList();
        list.add(100);
        list.add(901);
        List<Integer> listClone = (List<Integer>) list.clone();

        // 判断对象是否相等
        System.out.println("克隆的对象是否等于原来：" +(list == listClone));
        // 判断元素是否相等
        System.out.println("克隆的对象元素是否等于原来：" +(list.equals(listClone)));




        // 元素是 浅拷贝
        System.out.println(list.get(1) == listClone.get(1));

        // 校验元素是否是一个对象
        System.out.println(list.get(1).hashCode() + "_" + listClone.get(1).hashCode());


        list.remove(1);
        list.add(900);
        System.out.println(list.get(1)+"_"+(list.get(1) == listClone.get(1))+ "_"+listClone.get(1));


        // remiveif
        System.out.println("==============");
        System.out.println(list);

        list.removeIf(e->e>100);
        System.out.println(list);

    }

    public static void main(String[] args) {
        isCloneEqualPre();



    }
}