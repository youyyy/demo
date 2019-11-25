package StudyJava;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    }
}
