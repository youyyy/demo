package bishi;

import java.util.Scanner;

public class Sohu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        System.out.println(Sohu2.goAddOne(0,1,n));
    }
    public static int goAddOne(int i,int k,int n){
        while(i-k!=n||i+k!=n){
            if(i-2*k-1==n||i+1==n){
                return k+1;
            }
            if(i-1==n||i+2*k+1==n){
                return k+1;
            }
            i = i+k;
            k++;
        }
        if(i-k==n||i+k==n){
            return k;
        }
        int a = goAddOne(i-k,k+1,n);
        int b = goAddOne(i+k,k+1,n);
        return Math.min(a,b);
    }
}
