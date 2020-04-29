package com.example.demo.bean.context.datetype;
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

import java.util.Date;

/**
 * @program: demo
 * @description: 定制特殊的属性编辑器
 * @author: youyi
 * @create: 2020-04-28 18:18
 **/
public class DateType {
    private Date dateValue;

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    @Override
    public String toString() {
        return "DateType{" +
                "dateValue=" + dateValue +
                '}';
    }


}
