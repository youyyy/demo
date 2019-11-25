package bishi;

import java.util.Scanner;

public class Dianxin2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        boolean preIsNum = false;
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)<='9'&&a.charAt(i)>='0'&&preIsNum == false) {
                sb.append("*");
                sb.append(a.charAt(i));
                preIsNum = true;
            }else {
                if(a.charAt(i)>'9'||a.charAt(i)<'0'&&preIsNum == true){
                    sb.append("*");
                    preIsNum = false;
                }
                sb.append(a.charAt(i));
            }
        }
        if (sb.charAt(sb.length()-1)<='9'&&sb.charAt(sb.length()-1)>='0'){
            sb.append("*");
        }
        System.out.println(sb.toString());

    }
}
