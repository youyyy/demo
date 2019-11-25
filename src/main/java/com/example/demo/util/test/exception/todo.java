package com.example.demo.util.test.exception;

import java.math.BigDecimal;

/**
 * @Description
 * @Author youyi
 * @Date 2019/9/9 下午1:21
 **/
public class todo {
    public static void main(String[] args) {
        System.out.println(new BigDecimal(1.01).compareTo(new BigDecimal(1)));
    }
}
