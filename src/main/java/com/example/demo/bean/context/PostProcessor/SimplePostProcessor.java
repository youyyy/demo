package com.example.demo.bean.context.PostProcessor;
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

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-04-29 14:31
 **/
public class SimplePostProcessor {
    private String connectionString;
    private String password;
    private String username;

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SimplePostProcessor{" +
                "connectionString='" + connectionString + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
