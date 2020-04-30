package com.example.demo.util.jdbc;
/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-04-30 15:07
 **/
public class JdbcUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/youyi";
    public static final String USER = "root";
    public static final String PASSWORD = "9527";
    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM user");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        conn.close();


    }
}
