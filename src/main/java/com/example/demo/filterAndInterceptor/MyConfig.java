package com.example.demo.filterAndInterceptor;
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

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: demo
 * @description: 注册
 * @author: youyi
 * @create: 2020-05-09 11:08
 **/
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.setName("myFilter");
        registration.setOrder(1);
        return registration;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
