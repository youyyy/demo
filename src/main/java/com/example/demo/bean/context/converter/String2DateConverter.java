package com.example.demo.bean.context.converter;
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


import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.text.ParseException;
import java.util.Date;

/**
 * @program: demo
 * @description: convert的使用
 * @author: youyi
 * @create: 2020-04-30 10:55
 **/
public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        try{
            return DateUtils.parseDate(source,new String[] {"yyyy-MM-dd HH:mm:ss"});
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new String2DateConverter());

        String  date = "2020-04-22 14:12:23";
        Date date1 = conversionService.convert(date,Date.class);

        System.out.println(date1);
    }
}
