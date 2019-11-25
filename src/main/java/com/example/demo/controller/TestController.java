package com.example.demo.controller;

import com.example.demo.todoservice.IService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description: 用来测试 抽象类运用在SpringBoot项目里面
 * @author: youyi
 * @create: 2019-11-18 15:23
 **/
@Controller
@ResponseBody
public class TestController {
    @Resource(name = "myServiceB")
    private IService iServiceB;

    @GetMapping("/todo")
    public String todo(){
        return iServiceB.dodo();
    }
}
