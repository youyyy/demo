package bishi;

import java.util.Scanner;

public class Dianxin3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        if(n>100000){
            return;
        }
        int count = 0;
        for(int i=1;i<=n;i++){
            if(fx(i)==gx(i)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static int fx(int n){
        int count = 0;
        while(n>0){
            count = count +n%10;
            n = n/10;
        }
        return count;
    }
    public static int gx(int n){
        int countx = 0;
        while(n>0)
        {
            countx ++;
            n = n&(n-1);
        }
        return countx;
    }
}
