package com.example.demo.util.test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author youyi
 * @Date 2019/8/29 下午9:17
 **/
public class TOdo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5,6,7,8);

        list = handle(list);
        System.out.println(list);
        Integer date = Integer.parseInt(dateCalculation());
        System.out.println(date);
    }
    public static List<Integer> handle(List<Integer> list){
         return Arrays.asList(1,23,3);
    }
    public static String dateCalculation(){
        Long date1 = 1567094400L;
        Long date2 = 1566403200L;
        System.out.println(date1-date2);
        return String.valueOf((date1-date2)/86400);
    }


}
