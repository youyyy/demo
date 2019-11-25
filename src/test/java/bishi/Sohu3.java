package bishi;

import java.util.Scanner;

public class Sohu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        String[] temp = line.split("    ");
        String[] A = temp[0].split("\\.");
        String[] B = temp[1].split("\\.");
        int len = Math.max(A.length,B.length);
        for(int i=0;i<len;i++){
            if(i<A.length && i<B.length){
                if(Integer.parseInt(A[i])>Integer.parseInt(B[i])){
                    System.out.println(1);
                    return;
                }else if(Integer.parseInt(A[i])<Integer.parseInt(B[i])){
                    System.out.println(-1);
                    return;
                }
            }else if(i<A.length && i>=B.length){
                if(Integer.parseInt(A[i])>0){
                    System.out.println(1);
                    return;
                }else if(Integer.parseInt(A[i])<0){
                    System.out.println(-1);
                    return;
                }
            }else if(i>=A.length && i<B.length){
                if(0>Integer.parseInt(B[i])){
                    System.out.println(1);
                    return;
                }else if(0<Integer.parseInt(A[i])){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
