package demoTest;

import com.google.common.collect.Sets;

import java.util.Optional;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = Sets.newHashSet();
        set.add("1230");
        set.add("54");
        String key ="kkk";
        Optional.ofNullable(key).ifPresent(u-> System.out.println(u));
        Optional.ofNullable(key).orElseGet(String::new);
        Optional.ofNullable(key).orElseGet(()->new String("asdasd"));
        System.out.println(set.contains(key));
    }
    public void sou(String key){
        System.out.println("sou");
    }
}
