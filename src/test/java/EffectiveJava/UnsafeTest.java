package EffectiveJava;

import java.util.Date;

public class UnsafeTest {
    public static void main(String[] args) throws IllegalAccessException {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start,end);
        System.out.println(p.getEnd()+","+p.getStart());
        end.setYear(78);
        System.out.println(p.getEnd()+","+p.getStart());
        p.getEnd().setYear(78);
        System.out.println(p.getEnd()+","+p.getStart());

    }
}
