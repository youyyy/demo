package com.example.demo.util.MeicaiDoUtil;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author youyi
 * @Date 2019/8/1217:34
 **/
public class DateToLong {
    public static void main(String[] args) throws ParseException {
      Long date = System.currentTimeMillis();
      Integer date2 = 1565561461;
        System.out.println(isRightDate(date2));
    }

    /**
     * 日历Calendar转时间戳Long
     * @param time
     * @return
     * @throws ParseException
     */
    public static boolean isRightDate(Integer time) throws ParseException {

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());
        cal1.set(Calendar.HOUR_OF_DAY,11);
        cal1.set(Calendar.MINUTE,0);
        cal1.set(Calendar.SECOND,0);
        System.out.println(cal1.getTimeInMillis()/1000);
        System.out.println(cal1.getTime());

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.set(Calendar.HOUR_OF_DAY,23);
        cal2.set(Calendar.MINUTE,0);
        cal2.set(Calendar.SECOND,0);

        System.out.println(cal2.getTimeInMillis()/1000);
        System.out.println(cal2.getTime());

//        Date date = new Date();
//        date.setTime(time);
//        System.out.println(date);
        return time>cal1.getTimeInMillis() && time<cal2.getTimeInMillis();
    }
}
