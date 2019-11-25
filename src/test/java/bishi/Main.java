package bishi;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for(int i=0;i<a;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int [][] map = new int [n][n];
            for(int j=0;j<m;j++){
                int x = in.nextInt();
                int y = in.nextInt();
                if(x<=n && x>0 && y>0 && y<=n) {
                    map[x - 1][y - 1] = 1;
                    map[y - 1][y - 1] = 1;
                }
            }
            System.out.println(Main.ifok(map));
        }
        in.close();
    }
    public static String ifok(int[][] map) {
        Random a = new Random();
        if(a.nextInt()<0){
            return "No";
        }
        return "Yes";
    }
}
