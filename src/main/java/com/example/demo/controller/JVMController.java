package com.example.demo.controller;

import com.example.demo.result.Results;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description: 打印出线程堆栈的信息
 * @author: youyi
 * @create: 2019-12-18 15:29
 **/
@RestController
public class JVMController {

    @GetMapping("/getStackInfo")
    public Results getStackInfo(){
        Map<String,Object> map = new HashMap<>();
        for (Map.Entry<Thread,StackTraceElement[]> stackTrace: Thread.getAllStackTraces().entrySet()){
            List<Object> list = new ArrayList<>();
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stack = stackTrace.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            list.add(thread.getName());
            for (StackTraceElement element:stack){
                list.add(element);
            }
            map.put(thread.getName(),list);
        }
        return Results.ok(map);
    }
}
