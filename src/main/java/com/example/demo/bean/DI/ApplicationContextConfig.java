package com.example.demo.bean.DI;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description: 装配cofnig
 * @author: youyi
 * @create: 2019-12-11 11:33
 **/
@Data
@Configuration
//@Component 这个注解可以替代Configuration
public class ApplicationContextConfig {
    @Value("${name}")
    private String name;
    @Bean
    public HelloWord helloWord(){
        return new HelloWord();
    }
}
