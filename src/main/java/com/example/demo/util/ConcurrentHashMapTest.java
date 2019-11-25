package com.example.demo.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public String hello(int id){
        assert id>0;
        return "hello";
    }
    public static void main(String[] args) {
        ConcurrentHashMapTest test = new ConcurrentHashMapTest();
        System.out.println(test.hello(-1));
    }
}
