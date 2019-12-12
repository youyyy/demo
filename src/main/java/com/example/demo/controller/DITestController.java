package com.example.demo.controller;

import com.example.demo.bean.DI.ApplicationContextConfig;
import com.example.demo.bean.DI.HelloWord;
import com.example.demo.bean.DI.Word;
import org.apache.naming.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-11 11:11
 **/
@RestController
public class DITestController {

    @Resource
    ApplicationContextConfig config;
    @Resource
    Word word;
    @GetMapping("/getDiBean")
    public void getDiBean(){
        config.helloWord().getMessage();
        word.getMessage();
    }

    @GetMapping("/getConfig")
    public void getConfig(){
        System.out.println(config.getName());
    }
}
