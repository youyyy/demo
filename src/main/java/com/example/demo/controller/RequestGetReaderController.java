package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yi.you on 2018/8/16.
 */
@Controller
@RequestMapping("/test")
public class RequestGetReaderController {
    @RequestMapping("/readwrite")
    public void Readwrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //上传命令 curl <url> -f "",但是还不能用
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
            JSONObject object = JSON.parseObject(sb.toString());
            //out.write(object.toJSONString());
            System.out.println(object==null);
        } catch (IOException e) {
           out.print(e.toString());
        }
        out.write("success");
    }
}
