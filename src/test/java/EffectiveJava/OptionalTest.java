package EffectiveJava;


import java.util.*;

public class OptionalTest {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        /*a.add(1);
        a.add(5);
        a.add(6);*/

        //1.orElse()空，返回默认值
        System.out.println(OptionalTest.getmax(a).orElse(0));

        //2.空，抛出异常
        //System.out.println(OptionalTest.max(a).orElseThrow(NullPointerException::new));
        //System.out.println(OptionalTest.max(a).orElseThrow(()->new NullPointerException()));

        //3.取得值，null也会异常
        //System.out.println(OptionalTest.max(a).get());
        OptionalTest.max(a).orElseGet(()->new Integer(0));

        //4.验证值是否为存在，可以接受参数
        //a.add(1);
        OptionalTest.max(a).ifPresent(u-> System.out.println(u));

        System.out.println("=============");
        //map和flatMap
        String va = "test";
        System.out.println(Optional.ofNullable(va).map(b->b.length()).orElse(0));
        System.out.println("=============");

        String key = null;
        Optional.ofNullable(key).ifPresent(u-> System.out.println(u));
        Optional.ofNullable(key).orElseGet(String::new);
        System.out.println(Optional.ofNullable(key).orElseGet(() -> new String("asdasd")));


    }

    /**
     * 求最大值，返回可能为null
     * @param c
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty())
            return Optional.empty();
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return Optional.of(result);
    }
    public static <E extends Comparable<E>> Optional<E> getmax(Collection<E> c) {

        return c.stream().max(Comparator.naturalOrder());
    }
}
