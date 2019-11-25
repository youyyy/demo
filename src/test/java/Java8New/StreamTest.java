package Java8New;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        //
        List<String> list = Arrays.asList("test111","qunar2","youyi","win");
        //sorted只能用comparable接口的方法
        /**按字典顺序比较，返回第一个不同的值的ASCII码之差。如果前面都相等，返回长度之差**/
        List<String> end = list.stream().filter(s->s.length()>4).sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(end.toString());
        List<Integer> end2 = end.stream().map(s->s.length()).collect(Collectors.toList());
        System.out.println(end2.toString());
        System.out.println("==========================");

        String a = "test111";
        String b = "qunar2";
        System.out.println(a.compareTo(b));
        System.out.println("==========================");

        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);

        System.out.println("==========================");
        /**
         * @see     Set
         * @see     List
         * @see     Map
         * @see     SortedSet
         * @see     SortedMap
         * @see     HashSet
         * @see     TreeSet
         * @see     ArrayList
         * @see     LinkedList
         * @see     Vector
         * @see     Collections
         * @see     Arrays
         * @see     AbstractCollection
         */
        Collection<String> cl = new ArrayList<>();
        Stream<String> stream = Stream.of("9","2","3","4","1");
    }

}
