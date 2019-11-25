package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * httpclient 使用
 * Created by yi.you on 2018/8/14.
 */
@Controller
@ResponseBody
public class HttpClientController {
    @RequestMapping("/httpdopro")
    public void dopro(HttpServletRequest request, HttpServletResponse response){
        String content = request.getParameter("content");
        System.out.print(content);
    }
    @RequestMapping("/httpredopro")
    public Map<String,Object> redopro() throws IOException {
        Map<String,Object> result = new HashMap<String,Object>();
        String te= null;
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            URI url = new URIBuilder("http://localhost:8080/httpdopro").setParameter("content","hello").build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                // 获取服务端，响应的数据
                String content = EntityUtils.toString(response.getEntity(),
                        "UTF-8");
                System.out.println(content);
            }
            System.out.print(response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (response != null) {
                response.close();
            }
            client.close();
        }
        result.put("success",true);
        return result;
    }
    @RequestMapping("/postredopro")
    public Map<String,Object> postredopro() throws IOException {
        Map<String,Object> result = new HashMap<String,Object>();
        String te= null;
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://www.oschina.net/search");

        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("scope", "project"));
        parameters.add(new BasicNameValuePair("q", "java"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);
        // 伪装浏览器请求
        httpPost.setHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                // 获取服务端，响应的数据
                String content = EntityUtils.toString(response.getEntity(),
                        "UTF-8");
                System.out.println(content);
            }
            System.out.print(response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
        result.put("success",true);
        return result;
    }

}
