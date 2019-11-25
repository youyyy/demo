package CollectionTest.SetTest;

import reflection.Student;

import java.util.*;

/**
 * TreeSet实现{@link NavigableSet}接口，
 * 这个接口继承了{@link SortedSet},
 * 所以需要在类型里边实现{@link Comparable}接口，
 * 重写compareTo()
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<Student>();
        set.add(new Student("11","游移"));
        set.add(new Student("1","ta"));
        set.add(new Student("10","hh"));
        System.out.println(set);

    }
}
