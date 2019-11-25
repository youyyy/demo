package com.example.demo.util.StudyJDK;

/**
 * @Description 学习Java源码时，关于String的测试用例
 * @Author youyi
 * @Date 2019/8/118:19
 **/
public final class YString implements java.io.Serializable {


    public static void main(String[] args){
        String a = new String();

        String b = "adssa";

        char[] cc = {'a','k','i','s','t','h','e','b','e','s','t'};
        String c =  new String(cc);

        System.out.println(c);

        String d = new String(cc,1,5);
        System.out.println(d);

        System.out.println('s'==115);
        System.out.println(d.codePointAt(2));


        System.out.println(d.codePointBefore(1)=='k');

        System.out.println(d.codePointCount(0,5));

        System.out.println(d.equals(new Long(1)));

        System.out.println(new StringBuffer());

        System.out.println("==============");

        String s1 = "abcd";
        String s2 = "abcdef";

        System.out.println(s1.compareTo(s2));

        System.out.println("==============");
        // 忽略 大消息 比较器
        System.out.println(String.CASE_INSENSITIVE_ORDER.compare(s1, s2));

        // 比较指定位置的字符串
        System.out.println(s1.regionMatches(1, s2, 1, s1.length()-1));


        // 比较s2是不是以s1开头  可以设置从s2第几个开始
        System.out.println("===============");
        s1 = "abcd";
        s2 = "aabcdef";

        System.out.println(s2.startsWith(s1,1));

        System.out.println(s1.hashCode());
//        s1.indexOf
    }
}
