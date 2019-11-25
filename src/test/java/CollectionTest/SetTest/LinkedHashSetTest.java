package CollectionTest.SetTest;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("8");
        set.add("5");
        set.add("6");
        set.add("2");
        set.add("9");
        set.add("5");
        set.add("15");
        set.add("23");
        System.out.println(set);
    }
}
