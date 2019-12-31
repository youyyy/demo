package com.example.demo.bean.DI;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: demo
 * @description: 条件装配的条件
 * @author: youyi
 * @create: 2019-12-30 20:10
 **/
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        for (String activeProfile : env.getActiveProfiles()) {
            // 模拟profile的装配
            if (activeProfile.equals("dev")){
                return true;
            }
        }
        return false;
    }
}
