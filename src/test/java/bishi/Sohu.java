package bishi;

import java.util.Scanner;

public class Sohu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        String[] temp = line.split(" ");
        if(temp[0].length()==0||temp[1].length()==0||temp[0].length()!=temp[1].length()){
            System.out.println(0);
            return;
        }
        int count = 0;
        //先满足组成一致

        for(int i=0;i<temp[0].length();i++){
            for(int j=0;j<temp[1].length();j++){
                if(i!=j && temp[0].charAt(i)==temp[1].charAt(j)){
                    count++;
                    break;
                }
            }
        }
        if(count == temp[0].length()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
