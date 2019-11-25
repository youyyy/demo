package bishi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        char[] chars = line.toCharArray();
        Set<Character> set = new HashSet<Character>();
        String end = null;
        for(int i=0;i<chars.length;i++){
            char a = chars[i];
            for(int j=i+1;j<chars.length-1;j++){
                if (chars[j]==a){
                    set.add(a);
                    break;
                }
            }
            if(set.contains(a)){
                continue;
            }else{
                end = a+"";
            }
        }
        if(end==null){
            System.out.println("NULL");
        }else{
            System.out.println(end);
        }
    }
}
