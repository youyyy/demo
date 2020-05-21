package com.example.demo.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by yi.you on 2018/8/14.
 */
public class TestUtil {
    public String hello(){
        List<String> list = new ArrayList<String>();
        list.add("diyige");

        try{
            for(int i =0;i<2;i++){
                String k = list.get(i);
            }
        }catch (Exception e){
            return "yichang";
        }
        return "zuihou";
    }
    public static void main(String[] args){
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        List<String> list = new ArrayList<String>();
        map.put("list",list);
        System.out.println(map.get("list").toString());

        List a = Collections.synchronizedList(Arrays.asList(11));


    }
}
