package com.example.demo.controller;

import com.example.demo.bean.DI.ApplicationContextConfig;
import com.example.demo.bean.DI.Word;
import com.example.demo.bean.DI.XihaWord;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Resource(name = "youyi")
    User user;
    @Resource
    Word word;
    @Autowired
    XihaWord xihaWord;


    @GetMapping("/getDiBean")
    public void getDiBean(){
        config.helloWord().getMessage();
        config.xixiWord().getMessage();
        System.out.println(xihaWord.toString());
        word.getMessage();

    }

    @GetMapping("/getConfig")
    public String getConfig(){
        System.out.println(user);
        return config.getName();
    }
}
