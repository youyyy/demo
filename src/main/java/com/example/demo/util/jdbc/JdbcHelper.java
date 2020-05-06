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

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @program: demo
 * @description: jdbcTemplate观察用例
 * @author: youyi
 * @create: 2020-04-30 16:29
 **/
public class JdbcHelper {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dateSource){
        this.jdbcTemplate = new JdbcTemplate(dateSource);
    }
    public void update(){
        jdbcTemplate.update("insert into user(name,age) values (?,?)",new Object[]{1,1},new int[]{Types.VARCHAR, Types.INTEGER});
    }
}
