package com.example.demo.annotationTest;

import java.lang.annotation.*;

/**
 * @program: demo
 * @description: 自定义注解
 * @author: youyi
 * @create: 2019-10-15 17:48
 **/
@Target({ ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    /**
     * 模块
     */
    public String title() default "模块";

    /**
     * 功能
     */
    public String actType() default "功能";

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
