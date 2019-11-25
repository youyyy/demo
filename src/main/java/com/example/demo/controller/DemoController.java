package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yi.you on 2018/8/9.
 */
@Controller
@ResponseBody
public class DemoController {
    @Resource
    private DemoService demoService;
    private Logger logger  = LoggerFactory.getLogger(DemoController.class);
    @GetMapping("/hello")
    public Map<String,Object> SayHello(){
        logger.info("before");
        Map<String,Object> result = demoService.Hello("youyi");
        logger.info("after");
        return result;
    }
    @GetMapping("/gettest")
    public Map<String,Object> gettest(HttpServletRequest request){
        Map<String,Object> result = new HashMap<String,Object>();
        String id = request.getParameter("id");
        System.out.println(id);
        result.put("id",id);
        return result;
    }
}
