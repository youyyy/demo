package CollectionTest.SetTest;

import reflection.Student;

import java.util.HashSet;
import java.util.Set;

/**
 * 底层是一个hash表，封装了一层hashmap
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("11","游移"));
        set.add(new Student("1","ta"));
        set.add(new Student("10","hh"));
        System.out.println(set);

        System.out.println("========================");
        HashSet<Integer> loadsSet = new HashSet<Integer>();
        loadsSet.add(1);
        loadsSet.add(2);
        loadsSet.add(0);
        loadsSet.add(3);
        loadsSet.add(2);
        loadsSet.add(1);
        loadsSet.add(3);
        loadsSet.add(5);
        loadsSet.add(0);
        System.out.println(loadsSet);
    }
}
