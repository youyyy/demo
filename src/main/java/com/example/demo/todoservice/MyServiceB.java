package com.example.demo.todoservice;

import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-18 15:22
 **/
@Service("myServiceB")
public class MyServiceB extends AbstractMyService implements IService {
    @Override
    public String todo(){
        return "我是BService";
    }

    @Override
    public String dodo() {
        return todo();
    }
}
