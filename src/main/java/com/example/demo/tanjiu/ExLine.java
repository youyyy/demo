package com.example.demo.tanjiu;/*
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

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author youyi
 * @program demo
 * @description
 * @date 2022-11-07 15:10
 **/
@Data
public class ExLine {
    @ExcelProperty(index = 0)
    private String str;
}
