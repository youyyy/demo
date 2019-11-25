package demoTest;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yi.you on 2018/8/8.
 */
public class test {
    public static void main(String[] args){
        String test = "asd,ada,afsd,fgdf,";
        List<String> strings = Splitter.on(",").splitToList(test);
        int[] lis = {1,2,2,3};
        System.out.println(strings.toString());
        System.out.println(Arrays.asList(lis));
        System.out.println(Arrays.toString(lis));

        //枚举的测试
        List<AntiLevel> list = Lists.newArrayList(AntiLevel.values());
        for(AntiLevel a: list){
            System.out.println(a);
        }
        list.sort(Comparator.comparingInt(AntiLevel::getLevel));
        for(AntiLevel a: list){
            System.out.println(a);
        }
    }
}
