package com.example.demo.bean.DI;

import org.springframework.beans.factory.annotation.Value;

/**
 * @program: demo
 * @description: 运行时注入
 * @author: youyi
 * @create: 2019-12-31 15:16
 **/
public class XihaWord {
    @Value("${message}") String message;

    @Override
    public String toString() {
        return "XihaWord{" +
                "message='" + message + '\'' +
                '}';
    }
}
