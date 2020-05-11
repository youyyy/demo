package com.example.demo.es;
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

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-05-11 12:07
 **/
@Data
public class Author implements Serializable {
    /**
     * 作者id
     */
    private Long id;
    /**
     * 作者姓名
     */
    private String name;
    /**
     * 作者简介
     */
    private String remark;

    //setters and getters
    //toString

}

