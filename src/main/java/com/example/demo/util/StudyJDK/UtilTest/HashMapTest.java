package com.example.demo.util.StudyJDK.UtilTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-30 12:26
 **/
public class HashMapTest {
    int a;
    public static void main(String[] args) {

        //计算&n    和&n-1
        System.out.println(17&15);
        System.out.println(17&16);
        System.out.println("=============");

        System.out.println((-1&5)+"_"+(-1%5));
        System.out.println((-2&-6)+"_"+(-2%-6));
        System.out.println((-9&-6)+"_"+(-9%-6));

        // 测试hashMap计算key相等
//        String a = null;
//        String b = null;
//
//        System.out.println(a.equals(b));

        System.out.println("========");

        new HashMapTest().test();
        caculate();
        testHash();

        System.out.println("==========");
        for (int i=0;i<100;i++) {
            caculate2(new Random().nextInt(),16);
        }

        System.out.println("====merge======");

        merge();


    }

    // 测试HashMap里的计算容量阈值
    private static void caculate(){
        int cap = 64;
        int n = cap - 1;
        n |= n >>> 1;//  n + n/2
        n |= n >>> 2;//  n + n/4
        n |= n >>> 4;//  n + n/16
        n |= n >>> 8;//  n + n/256
        n |= n >>> 16;// n + n/65536

        System.out.println(n  +"  " + cap*2);

        System.out.println((-4)>>>1);
    }
    // 测试HashMap(Map<? extends K, ? extends V> m)
    private static void testHashMap(){
        Map<String,Integer> map = new HashMap<>();
        map.put("第一",100);
        map.put("第二",200);

        new HashMap<>(map);
    }
    // 全局变量不赋值
    void test(){
        if (10>a){
            System.out.println(a);
            System.out.println("测试成功");
        }
    }
    // 测试hash，其实是key的类型的hash
    private static void testHash(){
        Map<String,Integer> map = new HashMap<>();
        map.put("第一",100);
        map.put("第二",200);

        map.keySet().forEach(e->{
            System.out.println("key:"+e+"hash:"+e.hashCode());

        });
    }
    // 计算证明 resize函数中重新计算的的index为什么可以直接使用+n
    public static void caculate2(int hash,int n){
        System.out.println("oldIndex="+(hash & (n - 1)));

        System.out.println("条件：hash & n=" + (hash & n));
        if ((hash & n) != 0){
            System.out.println("newSet="+((hash & (n - 1))+n));
        }else {
            System.out.println("newSet="+((hash & (n - 1))));

        }

        System.out.println("newGet="+(hash & (2*n - 1)));

        System.out.println("============");

    }

    public static void merge(){
        Map<String,Integer> map = new HashMap<>();
        map.put("第一",100);
        map.put("第二",200);

        map.merge("哈哈",12,(k,v)->v+10);
        System.out.println(map);

        map.computeIfAbsent("diyi",k->10);
        System.out.println(map);

        map.computeIfPresent("diyi",(k,v)->v+10);
        System.out.println(map);

        map.computeIfPresent("dier",(k,v)->v+10);
        System.out.println(map);

        System.out.println(map.keySet().toString());

    }

    // 链表转红黑树




}
