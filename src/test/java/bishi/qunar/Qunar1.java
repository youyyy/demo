package bishi.qunar;

import java.util.*;

public class Qunar1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] temp = line.split(" ");
        in.close();
        Arrays.sort(temp);
        System.out.println(temp[temp.length/2]);
    }
}