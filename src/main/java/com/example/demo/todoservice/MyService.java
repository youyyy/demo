package com.example.demo.todoservice;

import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-18 15:10
 **/
@Service("myService")
public class MyService extends AbstractMyService implements IService {


    @Override
    public String todo(){
        return "a";
    }

    @Override
    public String dodo() {
        return todo();
    }
}
