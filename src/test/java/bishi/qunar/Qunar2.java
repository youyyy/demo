package bishi.qunar;

import java.util.Scanner;

public class Qunar2 {
    private static double myRound(double number,int index){
        double result = 0;
        double temp = Math.pow(10, index);
        result = Math.round(number*temp)/temp;
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.close();
        double e = 1.0;
        double t = 1.0;
        for (int i = 1; i <= 50; i++) {
            t /= i;
            e += t;
        }
        String temp = Double.toString(e);
        String end = temp.substring(0,k+2);
        double result = Double.parseDouble(end);
        System.out.println(myRound(e,k));
    }
}