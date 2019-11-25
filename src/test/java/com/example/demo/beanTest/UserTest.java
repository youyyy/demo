package com.example.demo.beanTest;

import com.example.demo.bean.User;
import org.junit.Test;

public class UserTest {
    @Test
    public void createUser() throws ClassNotFoundException {
        User user = User.Builder.anUser()
                .userId("0204150405")
                .userName("游移")
                .passWord("youyi")
                .tellphone("18780040578")
                .level("1").build();
        System.out.println(user);
        /*Class c =Class.forName(user.getClass().getName());
        System.out.println(c.toString());*/
    }
}
