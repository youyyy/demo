package com.example.demo.service.impl;

import com.example.demo.annotationTest.MyAnnotation;
import com.example.demo.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yi.you on 2018/8/9.
 * 自定义注解和
 */
@Service
@MyAnnotation(title="ClassDemoServiceImpl",actType = "DemoServiceImpl")
public class DemoServiceImpl implements DemoService{
    @Override
    @MyAnnotation(title="Hello",actType = "Service")
    // 方法上的注解， 和属性上的注解没做到
    public Map<String,Object> Hello(@MyAnnotation String s) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",new String("hello"));
        System.out.println("Hello !");
        HelloUse(s);
        return map;
    }

    public void HelloUse(String s){
        System.out.println("HelloUse"+"===="+s);
    }
}
