package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Thing> list = new ArrayList<Thing>();
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            list.add(new Thing(a,b,c));
        }
        in.close();
        int count = 0;
        for(int i=0;i<list.size();i++){
            for (int j=0;j<list.size();j++){
                if(!list.get(i).isok(list.get(j))){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}


class Thing{
    public int a;
    public int b;
    public int c;

    public Thing(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public boolean isok(Thing th) {
        if(this.a<th.a&&this.b<th.b&&this.c<th.c){
            return false;
        }
        return true;
    }
}
