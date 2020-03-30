package com.example.demo.controller;
/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

import com.example.demo.result.Results;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-03-30 15:00
 **/
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/set")
    @ResponseBody
    public Results setValue(){
        redisTemplate.opsForValue().set("name","xiaoyou");
        return Results.ok(redisTemplate.opsForValue().get("name"));
    }
}
