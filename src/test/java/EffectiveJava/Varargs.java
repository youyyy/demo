package EffectiveJava;

import java.util.*;

public class Varargs {
    static int sum(int ...args){
        int sum = 0;
        for(int arg:args){
            sum+=arg;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        if(list == null){
            System.out.println("null");
        }
        else if (list.size()==0){
            System.out.println(0);
        }
        System.out.println(sum());
    }


    public int min(List<Integer> list){
        list.forEach(k->{//foreach

        });
        list.sort(new Comparator<Integer>() {//重写
            @Override
            public int compare(Integer o1, Integer o2) {
                return 01;
            }
        });

        return 0;

    }
}
