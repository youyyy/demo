package com.example.demo.util.MeicaiDoUtil;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @program: demo
 * @description: description 这里主要是做数组的浅拷贝和深拷贝测试
 * @author: youyi
 * @create: 2019-10-08 14:28
 **/
public class ListCopyTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9,8,7,6,5,4,3,2,1);
        sort(list);
    }
    public static void sort(List<Integer> list){
        /**
         * 浅拷贝
         */
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        // 这里看是浅拷贝
        System.out.println("list==newList?   ="+(list == newList));
        System.out.println("(list.get(1)==newList.get(1))="+(list.get(2)==newList.get(2)));


        System.out.println("list.equals(newList)="+list.equals(newList));
    }
}
