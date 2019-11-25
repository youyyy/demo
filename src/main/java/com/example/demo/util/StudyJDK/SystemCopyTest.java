package com.example.demo.util.StudyJDK;

/*System中提供了一个native方法arraycopy()*/

/**
 * @program: demo
 * @description: 测试System里的Copy方法
 *
 * System.arraycopy  针对数组来说是深拷贝  对每一个元素来说是浅拷贝，每一个元素拷贝了一个引用
 * @author: youyi
 * @create: 2019-09-26 17:52
 **/
public class SystemCopyTest {
    public static void main(String[] args) {
        User [] users=new User[]{new User(1,"admin","admin@qq.com"),new User(2,"maco","maco@qq,com"),new User(3,"kitty","kitty@qq,com")};//初始化对象数组
        User [] target=new User[users.length];//新建一个目标对象数组
        System.arraycopy(users, 0, target, 0, users.length);//实现复制

        System.out.println("针对数组来说是:" + (users == target ?"浅复制":"深复制"));
        System.out.println("源对象与目标对象的物理地址是否一样（针对单个元素）："+(users[0] == target[0]?"浅复制":"深复制"));


        target[0].setEmail("admin@sina.com");
        System.out.println("修改目标对象的属性值后源对象users：");
        for (User user : users){
            System.out.println(user);
        }
    }
    private static class User {
        private Integer id;
        private String username;
        private String email;

        //无参构造函数
        public User() {
        }

        //有参的构造函数
        public User(Integer id, String username, String email) {
            super();
            this.id = id;
            this.username = username;
            this.email = email;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "User [id=" + id + ", username=" + username + ", email=" + email
                    + "]";
        }
    }
}
