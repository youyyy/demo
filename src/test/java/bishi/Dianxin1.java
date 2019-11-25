package bishi;

import java.util.Scanner;

public class Dianxin1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        int a[] = new int[n];
        for(int i=0;i<a.length;i++){
            a[i]=1;
        }
        int count=a.length;
        int san=0;
        int index=0;
        while(count>1){
            if(a[index]==1){
                san++;
                if(san==3){
                    a[index]=0;
                    san=0;
                    count--;
                }
            }
            index++;
            if(index==a.length)
                index=0;
        }
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==1)
            System.out.println(+i);
        }
    }
}
