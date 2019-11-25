package com.example.demo.util.StudyJDK.UtilTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @program: demo
 * @description: map的测试用例
 * @author: youyi
 * @create: 2019-10-14 17:18
 **/
public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> map =  new HashMap<>();
        // 测试Map的getOrDefault方法，避免了空指针
        map.put("times",10);
        System.out.println(map.get("age"));
        System.out.println(map.getOrDefault("age", 0));

        // 测试Map的replaceAll方法，类似于Stream
        map.replaceAll((k,v)->{
            return v+1;
        });
        // 这里的map只是将原对象与新对象形成一个关联，并不等同与map.replaceAll
        System.out.println(map.values().stream().map(t -> t + 1).collect(Collectors.toList()));

        System.out.println(map);

        // 测试 获取key不存在的时候得到的是不是null
        System.out.println(map.get("null"));
        //computeIfAbsent
        System.out.println(map.computeIfAbsent("null", k -> {
            return 100;
        }));
        //
        System.out.println("==================");
        // 测试merge函数
        System.out.println(map.merge("null", 2, (k, v) -> {
            return 1;
        }));

    }
}
