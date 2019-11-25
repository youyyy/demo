package Java8New;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        String[] k = {"asd","55","ger"};
        List<String> list = Arrays.asList(k);//不能把基础数据类型转List,返回的是一个数组的视图，操作都在数组上
        LambdaTest ob = new LambdaTest();
        //lambda表达式排序
        ob.sort(list);
        System.out.println(list);
        System.out.println(Arrays.toString(k));
        System.out.println("=======================");
        ob.finaltest();
        System.out.println("=======================");

        //lambda写多线程
        Thread thread = new Thread(()-> {
            System.out.println("new thread");
            System.out.println("======================");
        });
        thread.start();
        //方法引用写法
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        System.out.println(nums.stream().filter(num -> num != null).count());
        System.out.println(nums.size());

    }

    public void finaltest(){
        int num =1;
        Converter<Integer,String > s = (param)-> System.out.println(String.valueOf(param+num));
        s.convert(2);
    }
    @FunctionalInterface//函数式接口，
    public interface Converter<T1, T2> {
        void convert(int i);
    }
    public void sort(List<String> list){
        Collections.sort(list,(s1,s2) -> s1.compareTo(s2));
    }
}
