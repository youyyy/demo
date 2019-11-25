package com.example.demo.util.StudyJDK.UtilTest;

import java.util.*;

/**
 * @program: demo
 * @description: 测试AbstractCollection.toArray(T[] a)函数
 * @author: youyi
 * @create: 2019-10-14 11:39
 **/
public class CollectionTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("name","youyi");
        map.put("sex","man");
        map.put("phone","1222");
        map.put("age","22");
        map.put("home","chengdu");
        map.put("word","monkey");
        Collection<String> collection = map.values();
        System.out.println(collection.getClass());
        String[] a = new String[2];
        String[] b = new String[6];
        String[] c = new String[10];

        System.out.println(collection.toArray(a).length);
        System.out.println(collection.toArray(b).length);
        System.out.println(collection.toArray(c).length);

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == b);

    }

}
