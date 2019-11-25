package com.example.demo.aop;

import com.example.demo.annotationTest.MyAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-15 16:33
 **/
@Aspect
@Component
public class HelloAopTest {
    @Pointcut("execution(* com.example.demo.service..HelloUse(..))")
    private void poid2(){};
    // 没办法拦截内部方法的调用，如果需要拦截，那么需要获取到代理对象
    @Before("poid2()")
    public void doBeforeA(JoinPoint joinPoint){
        System.out.println("只拦截HelloUse方法");
    }

    /**
     * Pointcut
     * 定义Pointcut，Pointcut名称为aspectjMethod,必须无参，无返回值
     * 只是一个标识，并不进行调用
     */
    @Pointcut("execution(* com.example.demo.service..*(..))")
    private void aspectJMethod(){};

    @Before("aspectJMethod()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("----dobefore()开始----");
        System.out.println("执行业务逻辑前做一些工作");
        // 获取切面方法的传参
        Object[] o = joinPoint.getArgs();
        System.out.println("获取切面方法的传参" + o[0]);

        // 对注解进行操作
        try {
            MyAnnotation annotation = getAnnotationLog(joinPoint);
            System.out.println(annotation.title());
            System.out.println(annotation.actType());
            System.out.println(annotation.isSaveRequestData());
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("通过jointPoint获得所需内容");
        System.out.println("----dobefore()结束----");
    }
    /**
     * 是否存在注解，如果存在就获取
     */
    private MyAnnotation getAnnotationLog(JoinPoint joinPoint) throws Exception {
        // 类上的注解
        // 很重要 ！ joinPoint.getTarget().getClass()获取到当前切面的类
        MyAnnotation annotation1 = joinPoint.getTarget().getClass().getAnnotation(MyAnnotation.class);
        if (annotation1 != null) {
            System.out.println(annotation1.title());
            System.out.println(annotation1.actType());
            System.out.println(annotation1.isSaveRequestData());
        }


        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        // 方法上的注解
        if (method != null) {
            return method.getAnnotation(MyAnnotation.class);
        }
        return null;
    }

    @Around("aspectJMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{

        System.out.println("----doAround()开始----");
        System.out.println("此处可做一些类似before的工作");
        //核心逻辑
        //传入的新的参数去执行目标方法
        Object retval=pjp.proceed(new Object[]{"new YOUyi"});
        System.out.println("此处可做一些类似after的工作");
        System.out.println("----doAround()结束----");

        return retval;
    }
    @After(value="aspectJMethod()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("----doAfter()开始----");
        System.out.println("执行核心逻辑之后，所做工作");
        System.out.println("通过jointPoint获得所需内容");
        System.out.println("----doAfter()结束----");
    }
    // 可以获取返回值，做一些处理
    @AfterReturning(value="aspectJMethod()",returning="map")
    public Object doReturn(JoinPoint joinPoint, Map<String,Object> map){
        System.out.println("AfterReturning()开始");
        System.out.println("Return value= "+map.toString());
        map.put("data2","youyi");
        System.out.println("此处可对返回结果做一些处理");
        System.out.println("----AfterReturning()结束----");
        return map;

    }
    // 返回异常，可以对异常惊醒处理
    @AfterThrowing(value="aspectJMethod()", throwing="e")
    public void doThrowing(JoinPoint joinPoint,Exception e){
        System.out.println("-----doThrowing()开始-----");
        System.out.println(" 错误信息："+e.getMessage());
        System.out.println(" 此处意在执行核心业务逻辑出错时，捕获异常，并可做一些日志记录操作等等");
        System.out.println(" 可通过joinPoint来获取所需要的内容");
        System.out.println("-----End of doThrowing()------");
    }

}
