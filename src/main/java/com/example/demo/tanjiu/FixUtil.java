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

import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2021/9/15
 **/
public class FixUtil {

    public static void main(String[] args) {
        check();

    }

    public static void fun1(){
        List<String> nums = FileUtil.readLines(FileUtil.newFile("/Users/youyi/Desktop/fix/db.txt"), "UTF-8");

        ExLineListener exLineListener = new ExLineListener();
        EasyExcel.read(FileUtil.newFile("/Users/youyi/Desktop/fix/a1.xlsx"),ExLine.class,exLineListener)
                .doReadAll();
        EasyExcel.read(FileUtil.newFile("/Users/youyi/Desktop/fix/a2.xlsx"),ExLine.class,exLineListener)
                .doReadAll();
        List<ExLine> list = exLineListener.list;

        File file = FileUtil.newFile("/Users/youyi/Desktop/fix/end.txt");

        for (String string : nums) {
            List<ExLine> collect = list.stream().filter(e -> e.getStr().contains(string))
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(collect)){
                FileUtil.appendString(string,file,"UTF-8");
                FileUtil.appendString("\n",file,"UTF-8");
            }
        }

    }
    public static void fun2(){
        List<String> nums = FileUtil.readLines(FileUtil.newFile("/Users/youyi/Desktop/fix/activity_fw.txt"), "UTF-8");

        ExLineListener exLineListener = new ExLineListener();
        EasyExcel.read(FileUtil.newFile("/Users/youyi/Desktop/fix/a1.xlsx"),ExLine.class,exLineListener)
                .doReadAll();
        EasyExcel.read(FileUtil.newFile("/Users/youyi/Desktop/fix/a2.xlsx"),ExLine.class,exLineListener)
                .doReadAll();
        List<ExLine> list = exLineListener.list;

        File file = FileUtil.newFile("/Users/youyi/Desktop/fix/chongfubaoxiao.txt");

        for (String string : nums) {
            List<ExLine> collect = list.stream().filter(e -> e.getStr().contains(string))
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(collect)){
                FileUtil.appendString(string,file,"UTF-8");
                FileUtil.appendString("\n",file,"UTF-8");
            }
        }

    }


    public static void check(){
        List<String> nums = FileUtil.readLines(FileUtil.newFile("/Users/youyi/Desktop/check/activity_ing.txt"), "UTF-8");

        ExLineListener exLineListener = new ExLineListener();
        EasyExcel.read(FileUtil.newFile("/Users/youyi/Desktop/check/a1.xlsx"),ExLine.class,exLineListener)
                .doReadAll();
        EasyExcel.read(FileUtil.newFile("/Users/youyi/Desktop/check/a2.xlsx"),ExLine.class,exLineListener)
                .doReadAll();
        List<ExLine> list = exLineListener.list;

        File file = FileUtil.newFile("/Users/youyi/Desktop/check/bunengfaqi.txt");

        for (String string : nums) {
            List<ExLine> collect = list.stream().filter(e -> e.getStr().contains(string))
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(collect)){
                FileUtil.appendString(string,file,"UTF-8");
                FileUtil.appendString("\n",file,"UTF-8");
            }
        }

    }


}
