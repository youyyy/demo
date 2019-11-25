package com.example.demo.util.MeicaiDoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: demo
 * @description: 测试stream
 * @author: youyi
 * @create: 2019-10-24 17:27
 **/
public class StreamTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User("xiaoyou",22,"男","中南大学");
        User user2 = new User("youyi",29,"男","野鸡大学");
        User user3 = new User("heihei",12,"男","长沙大学");
        User user4 = new User("pinkpig",302,"男","粉红猪");
        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println(list.stream().filter(e -> e.getAge() > 19).map(e -> e.getName()).collect(Collectors.toList()));

        //  测试列表能不能加空元素
        List<String> list2 = new ArrayList<>();

        list2.add(null);
        list2.add(null);
        System.out.println(list2.isEmpty());
        System.out.println(list2.get(1) == null);

    }
    private static class User{
        String name;
        int age;
        String sex;
        String school;

        public User(String name, int age, String sex, String school) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.school = school;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }
    }
}
