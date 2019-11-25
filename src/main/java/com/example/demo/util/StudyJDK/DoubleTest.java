package com.example.demo.util.StudyJDK;

/**
 * @program: demo
 * @description: description 关于double的测试
 *
 * @author: youyi
 * @create: 2019-10-06 12:00
 **/
public class DoubleTest {
    public static void main(String[] args) {
        double a = 0x1.ffp+1;
        System.out.println(a);
        Double b = new Double(a);
        System.out.println(b.isNaN());


        // isNaN,NaN是唯一与自己不相等的值，NaN与任何值都不相等
        Double c = 0.0d/0.0;
        System.out.println("0.0d/0.0="+c+",isNaN:"+c.isNaN());

        System.out.println(b.hashCode());
    }
}
