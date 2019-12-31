package com.example.demo.bean.DI;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @program: demo
 * @description: 装配cofnig
 * @author: youyi
 * @create: 2019-12-11 11:33
 **/
@Data
@Configuration
@PropertySource("classpath:word.properties")
//@Component 这个注解可以替代Configuration
public class ApplicationContextConfig {
    @Autowired
    Environment env;

    @Value("${name}")
    private String name;
    @Bean
    public HelloWord helloWord(){
        return new HelloWord();
    }

    @Bean
    public XixiWord xixiWord(){
//        env.getRequiredProperty();
//        env.containsProperty();
        return new XixiWord(env.getProperty("message")+ System.currentTimeMillis());
    }

    @Bean
    public XihaWord xiha(){
//        env.getRequiredProperty();
//        env.containsProperty();
        return new XihaWord();
    }


}
