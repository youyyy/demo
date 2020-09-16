package com.example.demo.util;


import java.util.*;

/**
 * Created by yi.you on 2018/8/14.
 */
public class TestUtil {
    public String hello(){
        List<String> list = new ArrayList<String>();
        list.add("diyige");

        try{
            for(int i =0;i<2;i++){
                String k = list.get(i);
            }
        }catch (Exception e){
            return "yichang";
        }
        return "zuihou";
    }
    public static void main(String[] args){
//        Map<String,List<String>> map = new HashMap<String,List<String>>();
//        List<String> list = new ArrayList<String>();
//        map.put("list",list);
//        System.out.println(map.get("list").toString());
//
//        List a = Collections.synchronizedList(Arrays.asList(11));

        int[] a =new int[]{2,3,1} ;
        nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i >=0 ; i--) {
            int k = nums[i];
            for (int j = i-1; j >= 0 ; j--) {
                if (k>nums[j]){
                    nums[i] = nums[j];
                    nums[j] = k;
                    return;
                }
            }
        }
    }
}
