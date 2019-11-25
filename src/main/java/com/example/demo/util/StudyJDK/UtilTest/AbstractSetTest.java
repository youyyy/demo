package com.example.demo.util.StudyJDK.UtilTest;

import sun.lwawt.macosx.CSystemTray;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description: description AbstractSet的测试用例
 * @author: youyi
 * @create: 2019-10-15 10:31
 **/
public class AbstractSetTest {
    public static void main(String[] args) {
        equalsTest();
    }

    public static void equalsTest(){
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("youyi");
        set1.add("pig");
        set1.add("is");

        set2.addAll(set1);
        set1.add("hello");
        // set的判等  和包含测试   前者用了后者的方法
        System.out.println(set1.equals(set2));
        System.out.println(set1.containsAll(set2));

    }
}
