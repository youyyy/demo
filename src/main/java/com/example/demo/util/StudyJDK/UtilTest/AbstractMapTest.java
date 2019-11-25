package com.example.demo.util.StudyJDK.UtilTest;

import java.util.*;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-14 20:02
 **/
public class AbstractMapTest{

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("name","youyi");
        // 只有实例化为子类类型才能调用子类的重写的方法。
        System.out.println("浅拷贝："+map.clone().equals(map));

        // 若是实例化为父类的类型  不能调用子类重写的方法；
//        Map<String,Integer> map2 = new HashMap<>();
//        map2.clone();
        map.clone();
    }


}
