package demoTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yi.you on 2018/8/7.
 */
public class NullAddString {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        try {
            String test = null;
            map.put("hell","abc,"+test);
        }catch (Exception e){
            System.out.print(e.toString()+"添加");
        }
        try{
            String test2 = null;
            test2=map.get("hell");
            String[] test3 = test2.split(",");
            for(String a:test3){
                System.out.print(a);
            }
        }catch (Exception e){
            System.out.print(e.toString()+"取数据");
        }
    }
}
