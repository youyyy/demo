package com.example.demo.util.StudyJDK.UtilTest.concurrent.MyThreadPoolExecutor;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-21 15:32
 **/
public class test {
    private static final int size = Long.SIZE-4;
    public static void main(String[] args) {
        System.out.println(1<<29-1);
        System.out.println((-1)<<29);
        System.out.println(aplusb(10,11));
        System.out.println(aplusb(110,11));
        System.out.println("============");

        System.out.println(trailingZeros(11));

    }
    public static int aplusb(int a,int b){
        return  ((a&b)<<1) | (a^b);
    }
    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        // 递归即可
        if(n <5) {
            return 0;
        } else if(n == 5){
            return 1;
        }
        else{
            long c = 0;
            long a = n;
            while(a%10 == 0) {
                c++;
                a = a/10;
            }
            System.out.println("a="+c);
            return trailingZeros(n-1)+c;
        }
    }


}

