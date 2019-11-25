package bishi;

import java.util.Scanner;

public class Huawei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in .nextLine();
        in.close();
        String[] array = line.split(" ");
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<array.length;i++){
            sb.append(Huawei2.reverse(array[i]));
            if(i<array.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
    public static String reverse(String s){
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(s.length()-1-i));
        }
        return sb.toString();
    }
}
