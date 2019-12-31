package com.example.demo.bean.DI;

import com.example.demo.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-12-30 15:43
 **/
@Configuration
public class Dog {

    @Bean(name = "youyi")
    @Profile("prod")
    public User getUser(){
        return new User();
    }

    @Bean(name = "youyi")
    @Profile("dev")
    public User hehe(){
        User a = User.Builder.anUser().userName("youyi").build();
        return a;
    }
    // 条件装配
    @Conditional(MyCondition.class)
    @Bean(name = "youyi")
    public User haha(){
        User a = User.Builder.anUser().userId("09999").build();
        return a;
    }

}
