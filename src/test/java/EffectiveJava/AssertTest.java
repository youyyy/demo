package EffectiveJava;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AssertTest {
    public static String hello(int id){
        assert id>5;
        Assert.assertEquals(id,5);
        return "id="+id;
    }

    public static void main(String[] args) {
        System.out.println(AssertTest.hello(4));
        List<String> list = new ArrayList<>();
    }
}
