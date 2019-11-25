package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yi.you on 2018/8/9.
 */
@Controller
public class PageController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @GetMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
