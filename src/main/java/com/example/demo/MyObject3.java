package com.example.demo;/*
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

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2020/10/12
 **/
public class MyObject3 {
    public static void main(String[] args) {
        int[] nu = new int[]{1,0};
        moveZeroes(nu);
    }
    public static void moveZeroes(int[] nums) {
        //  找非0
        int i = 0;
        // 顺序
        int j = 0;
        while (i<nums.length && j<i){
            if (nums[i] == 0) {
                i++;
                continue;
            }
            if (i!=j){
                nums[j] = nums[i];
                nums[i] = 0;
            }
            j++;
        }
    }
}