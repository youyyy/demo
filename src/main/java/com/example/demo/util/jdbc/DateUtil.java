package com.example.demo.util.jdbc;
/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: demo
 * @description: 时间util
 * @author: youyi
 * @create: 2020-05-07 14:57
 **/
public class DateUtil {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_00_00_00 = "yyyy-MM-dd 00:00:00";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYYMMDDHH = "yyyyMMddHH";
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";

    public static Long dayToSecond(int day) {
        return day * 24 * 60 * 60L;
    }

    /**
     * 获取当前的时间点，单位是秒
     *
     * @return return
     */
    public static Long getCurrentSecond() {
        return System.currentTimeMillis() / 1000;
    }


    /**
     * 取得天日期
     *
     * @return
     */
    public static Date getCurrData() {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        try {
            return sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字符串形式的时间转换成long
     *
     * @param time   time
     * @param format format
     * @return return
     */
    public static Long StringToTime(String time, String format) {
        if (StringUtils.isEmpty(time)) {
            return 0l;
        }
        Long result = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            result = simpleDateFormat.parse(time).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 格式化时间时间单位是【毫秒】，一定要注意
     *
     * @param time   time
     * @param format format
     * @return return
     */
    public static String foramtTime(Long time, String format) {
        String result = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

            result = simpleDateFormat.format(time * 1000);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    /**
     * 得到当前日期格式化后的字符串，格式：yyyy-MM-dd(年-月-日)
     *
     * @return 当前日期格式化后的字符串
     */
    public static String getTodayStr() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getTodayLong() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /**
     * 获取几天前的日期20200419
     * @param day 为负数
     * @return
     */
    public static String getTodayStrBefore(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
    }

    public static String getTargetDay(Long time) {
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        String date = format.format(time * 1000);
        Date d = null;
        try {
            d = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("yyyyMMdd").format(d);
    }

    public static String getTodaySecLong() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /**
     * 时间戳，格式:yyyy-MM-dd HH:mm:ss(年-月-日  时：分：秒)
     *
     * @return 简单的时间戳
     */
    public static String getDateTimeStamp(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static Date getDateByString(String str) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dateTime = null;
        try {
            dateTime = sim.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    /**
     * 获取当前时间戳，格式:yyyy-MM-dd HH:mm:ss(年-月-日  时：分：秒)
     *
     * @return
     */
    public static String getCurrTimestamp() {
        // Format the current time.
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // yyyyMMddddhhmmssSSS
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 得到传来日期的前一天开始时间
     *
     * @param date
     * @return
     */
    public static String getDayBeforeStime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return format(calendar.getTime(), "yyyy-MM-dd 00:00:00");
    }

    /**
     * 将date按照pattern转换成对应的Long类型时间
     *
     * @param date
     * @param pattern yyyy-MM-dd
     * @return “20190129
     */
    public static Long getDate(Date date, String pattern) throws ParseException {
        if (date == null) {
            throw new ParseException("传入日期为空", 1);
        }
        return Long.parseLong(new SimpleDateFormat(pattern).format(date));
    }

    /**
     * 得到传来日期的当天开始时间
     *
     * @param date
     * @return
     */
    public static String getDayStime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return format(calendar.getTime(), YYYY_MM_DD_00_00_00);
    }

    /**
     * 把时间戳转换成date
     */
    public static Date timestampToDate(Long time) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        String date = format.format(time * 1000);
        Date d = format.parse(date);
        return d;
    }

    /**
     * 得到传来日期的前一天结束时间
     *
     * @param date
     * @return
     */
    public static String getDayAfterEtime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return format(calendar.getTime(), "yyyy-MM-dd 23:59:59");
    }

    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 根据指定的格式得到指定时间的时间戳
     *
     * @param pattern 指定的格式
     * @return 指定格式的时间戳
     * @prram date 指定的时间
     */
    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 获取当天0点的时间
     *
     * @return
     */
    public static Long getCurrentDay() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Calendar date = Calendar.getInstance();
        date.setTime(ts);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date.getTimeInMillis() / 1000;
    }

    /**
     * 获取整点时间
     *
     * @return
     */
    public static Long getIntegralTime() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Calendar date = Calendar.getInstance();
        date.setTime(ts);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date.getTimeInMillis() / 1000;
    }

    /**
     * 获取指定日期零点时间戳
     *
     * @param time
     * @return
     */
    public static Long getDayDate(Long time) throws ParseException {
        Date d = new Date(time * 1000);
        Calendar date = Calendar.getInstance();
        date.setTime(d);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date.getTimeInMillis() / 1000;
    }

    /**
     * 获取指定日期23时间戳
     *
     * @param time
     * @return
     */
    public static Long getDayEndDate(Long time) {
        Date d = new Date(time * 1000);
        Calendar date = Calendar.getInstance();
        date.setTime(d);
        date.set(Calendar.HOUR_OF_DAY, 23);
        date.set(Calendar.SECOND, 59);
        date.set(Calendar.MINUTE, 59);
        return date.getTimeInMillis() / 1000;
    }

    @Deprecated
    public static long getBeforeDayByNow(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取前几天零点的秒数
     *
     * @param days
     * @return
     */
    public static long getBeforeDay(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取前几天零点的秒数
     *
     * @param days
     * @return
     */
    public static long getBeforeDayAndHour(int days, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取后几天零点的秒数
     *
     * @param days
     * @return
     */
    public static long getAfterDayByNow(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, +days);
        return calendar.getTimeInMillis() / 1000;
    }


    /**
     * 获取近几天0点的时间戳
     *
     * @param days
     * @return
     */
    public static List<Long> getBeforeDays(int days) {
        List<Long> dateList = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.add(Calendar.DAY_OF_YEAR, -i);
            dateList.add(calendar.getTimeInMillis() / 1000);
        }
        return dateList;
    }

    /**
     * 获取后几天0点的时间戳
     *
     * @param days
     * @return
     */
    public static List<Long> getAfterDays(int days) {
        List<Long> dateList = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.add(Calendar.DAY_OF_YEAR, i);
            dateList.add(calendar.getTimeInMillis() / 1000);
        }
        return dateList;
    }

    /**
     * 获取近几周周末 0点的时间戳的
     *
     * @param days
     * @return
     */
    public static List<Long> getBeforeEndWeekDays(int days) {
        List<Long> dateList = new ArrayList<>();
        for (int i = 1; i <= days; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.add(Calendar.DAY_OF_YEAR, -i * 7);
            Date date = new Date(calendar.getTimeInMillis());
            Long time = getEndWeekday(date);
            dateList.add(time);
        }
        return dateList;
    }

    /**
     * 获取近几月月末 0点的时间戳的
     *
     * @param days
     * @return
     */
    public static List<Long> getBeforeEndMonthDays(int days) {
        List<Long> dateList = new ArrayList<>();
        for (int i = 1; i <= days; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -i);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date date = new Date(calendar.getTimeInMillis());
            Long time = getDefaultDay(date);
            dateList.add(time);
        }
        return dateList;
    }

    public static Long getDefaultDay(Date d) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime(d);
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
        lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

        return lastDate.getTimeInMillis() / 1000;
    }

    /**
     * 获取指定时间自然周0点的开始时间
     * n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
     * liangxuetan
     *
     * @return
     */
    public static Long getMondayOFWeek(Long time, int n) {
        Date d = new Date(time * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(GregorianCalendar.DATE, n * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取指定时间自然周周末0点的时间
     * n为推迟的周数，0本周，-1向前推迟一周，1下周，依次类推
     * liangxuetan
     *
     * @return
     */
    public static Long getEndOFWeek(Long time, int n) {
        Date d = new Date(time * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(GregorianCalendar.DATE, (n + 1) * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTimeInMillis() / 1000;
    }

    public static Date getFirstDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cal.getTime();
    }

    public static String getTimeOfWeek(String s) {
        int day = Integer.parseInt(s);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_WEEK, 1);
            calendar.add(Calendar.DAY_OF_MONTH, day);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
    }

    public static String getTimeOfMounth(String s) {
        int day = Integer.parseInt(s);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, day);
//            calendar.add(Calendar.DAY_OF_MONTH, day);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(DateUtil.YYYYMMDD).format(calendar.getTime());
    }

    /**
     * 当前日期增加s周
     * @param s
     * @return
     */
    public static String addWeek(int s) {

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+(7*s));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(DateUtil.YYYYMMDD).format(calendar.getTime());
    }
    /**
     * 当前日期增加s月
     * @param s
     * @return
     */
    public static String addMounth(int s) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+s); //增加一月
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(DateUtil.YYYYMMDD).format(calendar.getTime());
    }

    /**
     * 设置日期加x天
     * @param x
     * @return
     */
    public static String addXDay(String date,int x) {
        Calendar calendar = Calendar.getInstance();
        try {
            DateUtil.StringToTime(date,DateUtil.YYYYMMDD);
            calendar.setTimeInMillis(DateUtil.StringToTime(date,DateUtil.YYYYMMDD)*1000);
            calendar.add(Calendar.DAY_OF_MONTH, x);//增加一月
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(DateUtil.YYYYMMDD).format(calendar.getTime());
    }

    /**
     * 设置日期加x周
     * @param x
     * @return
     */
    public static String addXWeek(String date,int x) {
        Calendar calendar = Calendar.getInstance();
        try {
            DateUtil.StringToTime(date,DateUtil.YYYYMMDD);
            calendar.setTimeInMillis(DateUtil.StringToTime(date,DateUtil.YYYYMMDD)*1000);
            calendar.add(Calendar.DAY_OF_MONTH, x*7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(DateUtil.YYYYMMDD).format(calendar.getTime());
    }

    /**
     * 设置日期加x月
     * @param x
     * @return
     */
    public static String addXMounth(String date,int x) {
        Calendar calendar = Calendar.getInstance();
        try {
            DateUtil.StringToTime(date,DateUtil.YYYYMMDD);
            calendar.setTimeInMillis(DateUtil.StringToTime(date,DateUtil.YYYYMMDD)*1000);
            calendar.add(Calendar.MONTH, x); //增加一月
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(DateUtil.YYYYMMDD).format(calendar.getTime());
    }

    /**
     * 返回两个时间之间相差的天数集合列表
     *
     * @param startDate 形如20200401
     * @param endDate   形如20200405
     * @return
     */
    public static List<Long> getDayListByRange(Integer startDate, Integer endDate) {
        if (ParamUtil.isIntegerEmpty(startDate) || ParamUtil.isIntegerEmpty(endDate)) {
            return null;
        }
        List<Long> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        try {
            min.setTime(sdf.parse(startDate.toString()));
            max.setTime(sdf.parse(endDate.toString()));
            max.add(Calendar.DATE, 1);
        } catch (Exception e) {
            return null;
        }
        while (min.before(max)) {
            list.add(Long.valueOf(sdf.format(min.getTime())));
            min.add(Calendar.DATE, 1);
        }
        return list;
    }

    public static int diffDays(Integer startDate, Integer endDate) {
        List<Long> diffDays = getDayListByRange(startDate, endDate);
        return ParamUtil.isNullList(diffDays) ? 0 : diffDays.size();
    }



    public static void main(String[] args) throws Exception {

//        System.out.println(DateUtil.getTodayLong());
//        System.out.println(DateUtil.getTodayStrBefore(1));

//        int hour = calendar.get(Calendar.HOUR_OF_DAY);// 获取小时
//        int minute = calendar.get(Calendar.MINUTE);// 获取分钟
//        try {
//            calendar.setFirstDayOfWeek(Calendar.MONDAY);
//
//            calendar.setTime(new Date());
//            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String s = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());


        System.out.println(addXDay("20200427",2));
        System.out.println(addXWeek("20200427",1));
        System.out.println(addXMounth("20200427",1));
//        System.out.println(addMounth(2));



        List<Long> whichDayBeforeDays = getWhichDayBeforeDays(2, 1559145600L);
        System.out.println("getWhichDayBeforeDays(-2, 1556640000) = " + whichDayBeforeDays);
//        System.out.println(Long.valueOf("100"));
//        Long tmp = DateUtil.getBeforeDayByNow(1);
//        System.out.println(tmp / 1000);
//
//        Date d = getDateAfter(new Date(), -1);
//        System.out.println(">>>>>>" + getCurrentDay() + "====当前周：" + getMondayOFWeek(d) + "====当前月：" + getFirstDayOfMonth(d));
//        System.out.println(">>>>>>" + getAfterDayTimestampByCurrentDayFinish(0));
//        System.out.println(">>>>>>>当前日期：" + getBeforeDay(6));
//        System.out.println(">>>>>>>获取近7天:" + JsonUtilNew.writeValueAsString(getAfterDays(3)));
//        System.out.println(">>>>>>>获取近5周:" + JsonUtilNew.writeValueAsString(getBeforeEndWeekDays(5)));
//        System.out.println(">>>>>>>获取近5月月末:" + JsonUtilNew.writeValueAsString(getBeforeEndMonthDays(5)));
//        System.out.println(">>>>>" + getDayEndDate(1531942963L));
//        System.out.println(">>>>>" + getTargetDay(1539675747L));
//        System.out.println(">>>>>" + getMondayOFWeek(1543248000L, -3));
//        System.out.println(">>>>>" + getEndOFWeek(1543248000L, -1));
//        System.out.println("==========");
//        System.out.println(getThisWeekLastDay(1554307200l));
        //       System.out.println(calurateSecondByTime(1562945441l));
//        BigDecimal  day1=new BigDecimal(10);
//        BigDecimal  day3=new BigDecimal(0);
//        BigDecimal  day2=new BigDecimal(5);
//        BigDecimal dayValue= day1.add(day3.multiply(day2)).setScale(0, BigDecimal.ROUND_UP);
//        System.out.println(dayValue.toString());

        System.out.println(getDayDate(new Date().getTime()/1000));

        System.out.println( DateUtil.timestampToDate(DateUtil.getBeforeDayByDate(3,new Date())/1000+8*3600));

    }

    /**
     * 当前月第一天0点
     *
     * @return
     */
    public static Long getFirstDayOfMonth(Date d) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime(d);
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.set(Calendar.HOUR_OF_DAY, 0);
        lastDate.set(Calendar.MINUTE, 0);
        lastDate.set(Calendar.SECOND, 0);
        return lastDate.getTimeInMillis() / 1000;
    }

    /**
     * 获取自然周0点的开始时间
     *
     * @return
     */
    public static Long getMondayOFWeek(Date d) {
        int weeks = 0;
        int mondayPlus = getMondayPlus(d);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(d);
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);

        return currentDate.getTimeInMillis() / 1000;
    }

    public static int getMondayPlus(Date d) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(d);
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        //int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK); // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    public static Long getEndWeekday(Date d) {
        int mondayPlus = getMondayPlus(d);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(d);
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return currentDate.getTimeInMillis() / 1000;
    }

    public static Long getBeforeDayByDate(int days, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTimeInMillis();
    }

    public static long getAfterDayTimestampByCurrentDayFinish(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTimeInMillis() / 1000;
    }


    /**
     * 获取当前日期是本周第几天　返回1->7
     */
    public static Integer getWeekOfToday() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获取当前日期是本月第几天　返回1->31
     */
    public static Integer getMonthOfToday() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前日期是本月第几天　返回1->23
     */
    public static Integer getHourOfToday() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前日期的小时数
     */
    public static Integer getHourOfTime(Long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time * 1000);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前日期的分钟数
     */
    public static Integer getMinuteOfTime(Long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time * 1000);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 获取传入日期当天零点的时间戳
     */
    public static Long getZeroTimestamp(Long time) {
        String singInDate = foramtTime(time, YYYY_MM_DD_HH_MM_SS);
        Long zeroTimestamp = DateUtil.StringToTime(singInDate, YYYY_MM_DD);
        return zeroTimestamp;
    }

    /**
     * 把只有时分秒的时间戳转换成字符串时分秒
     */
    public static String changeStampToHMS(Long time) {
        Long h = time / 3600;
        Long m = (time - 3600 * h) / 60;
        Long s = time - 3600 * h - 60 * m;
        String resultTime = "";
        if (h < 10) {
            resultTime = "0" + h + ":";
        } else {
            resultTime = h + ":";
        }

        if (m < 10) {
            resultTime = resultTime + "0" + m + ":";
        } else {
            resultTime = resultTime + m + ":";
        }

        if (s < 10) {
            resultTime = resultTime + "0" + s;
        } else {
            resultTime = resultTime + s;
        }
        return resultTime;
    }

    /**
     * 獲取多少天的秒數
     *
     * @param days
     * @param date
     * @return
     */
    public static Long getBeforeDayByDateSecond(int days, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTimeInMillis() / 1000;
    }
    /**
     * 獲取多少天的秒數
     *
     * @param days
     * @param time
     * @return
     */
    public static Long getBeforeDayByDateSecond(int days, Long time) {
        Calendar calendar = Calendar.getInstance();
        Timestamp ts = new Timestamp(time*1000);
        calendar.setTime(ts);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 獲取某天小时的整点数
     *
     * @param time
     * @param time
     * @return
     */
    public static Long getHourZeroByTime(Long time,int days,Integer  hour) {
        Calendar calendar = Calendar.getInstance();
        Timestamp ts = new Timestamp(time*1000);
        calendar.setTime(ts);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取指定日期前几天的yyyy-MM-dd格式的日期
     *
     * @param d
     * @param day
     * @return
     */
    public static String getDayBeforeStr(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return format(now.getTime(), YYYY_MM_DD);
    }

    /**
     * 时间戳 毫秒转换秒
     *
     * @param timemillis
     * @return
     */
    public static Long getDateSecond(Long timemillis) {
        return timemillis / 1000;
    }

    public static Date formateStringToDate(String calDate, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = simpleDateFormat.parse(calDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取以当前时间戳为参考点的上一周周一到周五的时间戳List
     *
     * @param target 为秒时间戳 【注意】
     * @return
     */
    public static List<Long> getLastMon2Fri(Long target) {
        List<Long> list = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(target * 1000l));
            int n = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (n == 0) {
                n = 7;
            }
            cal.add(Calendar.DATE, -(7 + (n - 1) - i));
            Date day = cal.getTime();
            long dateTime = day.getTime() / 1000;
//            System.out.println(dateTime);
            list.add(dateTime);
        }
        return list;
    }

    /**
     * 如果当前时间为周二返回周一00：00：00的时间戳，以此类推， 周六日周一用周五时间戳
     *
     * @param dateTime
     * @return
     */
    public static Long getLastDateTime(Long dateTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(dateTime * 1000l));
        int n = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (n == 0) {//周日
            cal.add(Calendar.DATE, -2);// 取周五
            Date day = cal.getTime();
            return day.getTime() / 1000;
        } else if (n == 1) { //周一
            cal.add(Calendar.DATE, -3);// 取周五
            Date day = cal.getTime();
            return day.getTime() / 1000;
        } else {
            cal.add(Calendar.DATE, -1);// 取前一天
            Date day = cal.getTime();
            return day.getTime() / 1000;
        }
    }

    /**
     * 根据传入的时间戳求本周最后一天的时间戳，注意：时间戳为秒，返回也是秒
     *
     * @param target
     * @return
     */
    public static Long getThisWeekLastDay(Long target) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(target * 1000L));

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return cal.getTime().getTime() / 1000;

    }

    /*
     * 日期格式字符串转换成时间戳
     * @param dateStr   字符串日期
     * @param format    如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Long dateStr2TimeStamp(String dateStr, String format) {
        if (format == null) {
            format = "yyyy-MM-dd";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }


    /**
     * 秒 变 时间分区 15分钟分区
     *
     * @param second
     * @return
     */
    public static Long second2QuarterSec(Long second) {
        if (second == null) {
            return null;
        }
        if (second <= 0) {
            return 0L;
        }
        if (second > dayToSecond(1)) {
            second = Math.abs(second - DateUtil.getCurrentDay());
        }
        return (second / (60 * 15)) % (24 * 4);
    }

    /**
     * 时间字符串 翻译 成 秒
     *
     * @param hourMinuteStr
     * @return
     */
    public static Long hourMinuteStr2Second(String hourMinuteStr) {
        if (StringUtils.isBlank(hourMinuteStr)) {
            return null;
        }
        hourMinuteStr = hourMinuteStr.replaceAll(" ", "");
        hourMinuteStr = hourMinuteStr.replaceAll("：", ":");

        String[] timeArr = hourMinuteStr.split(":");

        Integer hour = null;
        Integer minute = 0;

        try {
            if (timeArr.length > 0) {
                hour = Integer.parseInt("" + timeArr[0]);
            } else {
                return null;
            }
            if (timeArr.length > 1) {
                minute = Integer.parseInt("" + timeArr[1]);
            }
        } catch (Exception e) {
            return null;
        }
        if (hour > 23 || minute > 59) {
            return null;
        }
        Integer ret = hour * 3600 + (minute * 60);

        return ret.longValue();
    }

    /**
     * Long类型转化为当前的Date
     *
     * @param time 1556982000L
     * @return 2019-05-04 23:00:00
     */
    public static String getCurrentDate(Long time) {
        return DateUtil.foramtTime(time, DateUtil.YYYY_MM_DD_HH_MM);
    }

    /**
     * 根据当前时间获取前7天的时间戳
     *
     * @param dateTime
     * @return
     */
    public static List<Long> getLast7Day(Long dateTime) {
        List result = new ArrayList();
        long onedaySeconds = 24 * 60 * 60L;
        for (int i = 7; i > 0; i--) {
            result.add(dateTime - i * onedaySeconds);
        }
        return result;
    }

    /**
     * @param dateKey 指定时间戳
     * @param weekDay 0,1,2,3,4,5,6  分别代表 日一二三四五六
     * @return
     */
    public static Long lastWeekDay(Long dateKey, Integer weekDay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateTime = format.parse(format.format(dateKey * 1000));
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateTime);
            int dateWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (dateWeek >= weekDay) {
                //取这周weekDay
                return dateKey - (dateWeek - weekDay) * 86400;
            } else {
                //取上周weekDay
                cal.add(Calendar.DATE, weekDay - dateWeek - 7);
                return cal.getTimeInMillis() / 1000;
            }
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @return 参数里每天对应的时间戳
     * @params n个时间，以空格隔开，比如"20190203 20181223 20190407"
     */
    public static List<Long> getTimeBySomeDate(String params) {
        List<Long> list = new ArrayList<>();
        if (!StringUtils.isEmpty(params)) {
            String trim = params.trim();
            String[] arr = trim.split("\\s+");
            if (arr != null && arr.length > 0) {
                for (int i = 0; i < arr.length; i++) {
                    // 20190402格式转化成时间戳
                    Long dateTime = DateUtil.StringToTime(arr[i] + "", DateUtil.YYYYMMDD);
                    list.add(dateTime);
                }
                return list;
            }
        }
        return null;

    }

    /**
     * @param dateTimeRange 格式为20190203-20190312
     * @return 把这个范围内地时间都转成时间戳
     */
    public static List<Long> getTimeByRange(String dateTimeRange) {
        List<Long> list = new ArrayList<>();
        if (!StringUtils.isEmpty(dateTimeRange)) {
            String trim = dateTimeRange.trim();
            String[] split = trim.split("-");
            if (split.length == 2) {
                Long start = DateUtil.StringToTime(split[0] + "", DateUtil.YYYYMMDD);
                Long end = DateUtil.StringToTime(split[1] + "", DateUtil.YYYYMMDD);
                while (end >= start) {
                    list.add(start);
                    start += 24 * 60 * 60; //加一天
                }
                return list;
            }
        }
        return null;
    }

    /**
     * 指定哪天为开始获取近几天0点的时间戳
     *
     * @param days
     * @return
     */
    public static List<Long> getWhichDayBeforeDays(int days, Long supposeToday) {
        List<Long> dateList = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(supposeToday * 1000));
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.add(Calendar.DAY_OF_YEAR, -i - 1);
            dateList.add(calendar.getTimeInMillis() / 1000);
        }
        return dateList;
    }

    /**
     * 返回当前时间的前一天的 0点的时间戳
     *
     * @return
     */
    public static long getBeforeDayBegin() {
        Long dateTime = DateUtil.StringToTime(DateUtil.format(new Date(), DateUtil.YYYYMMDD), DateUtil.YYYYMMDD);
        return dateTime - 24 * 60 * 60L;
    }

    public static String getYesterdayStr(Long currentDay) {
        return DateUtil.foramtTime((currentDay - 24 * 3600L), DateUtil.YYYYMMDD);
    }

    /**
     * 把时间戳转换成date然后算出小时和分钟换成秒数  如2019-07-12 10:30:41  换成10*3600+30*60
     */
    public static Integer calurateSecondByTime(Long time) throws Exception {
        Date reportData=new Date(time*1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reportData);
        int hourValue=calendar.get(Calendar.HOUR_OF_DAY);
        int minuteValue=calendar.get(Calendar.MINUTE);
        return hourValue*3600+minuteValue*60;
    }

    public static Integer checkAndParseDateKey(String dateKeyStr) {
        if (StringUtils.isNotBlank(dateKeyStr)) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                format.setLenient(false);
                //处理2020043=>20200403
                Date date = format.parse(dateKeyStr);
                return Integer.parseInt(format.format(date));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
