import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author youyi
 * @Date 2019/7/239:49
 **/
public class DoTest {
    public static void main(String[] args){
        test1();
        System.out.println("===============================");
        test2();
    }

    public static void test1(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<String,String>();
        Map<String,String> map2 = new HashMap<String,String>();
        Map<String,String> map3 = new HashMap<String,String>();
        Map<String,String> map4 = new HashMap<String,String>();

        map1.put("name","hello_1");
        map2.put("name","hello_2");
        map3.put("name","hello_3");
        map4.put("name","hello_4");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        System.out.println("size="+list.size());
        System.out.println("name="+list.get(0).get("name"));
        List<String> listEnd = list.stream().map(t -> t.get("name")).collect(Collectors.toList());
        System.out.println("all="+listEnd);
        System.out.println(list.stream().filter(t -> t.size() > 0).count());


    }
    public static void test2(){

        List<Staff> staff = Arrays.asList(
                new Staff("ricky", 30, new BigDecimal(100)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("jackchen", 27, new BigDecimal(2000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }
        System.out.println(result); //[ricky, jack, lawrence]

        //Java 8
        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //[ricky, jack, lawrence]

        List<String> collect2 = staff.stream().map(t->t.getName()).collect(Collectors.toList());
        /**
         * jdk8 stream
         * 统计分类数量
         */
        Map<Integer,Long> map = staff.stream().collect(Collectors.groupingBy(
                Staff::getAge,Collectors.counting()));
        map = staff.stream().collect(Collectors.groupingBy(t->t.getAge(),Collectors.counting()));
        System.out.println(map.toString());




    }


}
