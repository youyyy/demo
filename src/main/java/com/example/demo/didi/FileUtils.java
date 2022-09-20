package com.example.demo.didi;/*
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
import com.google.common.base.Splitter;
import org.elasticsearch.common.Strings;

import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2021/9/15
 **/
public class FileUtils {
    private static String a = "curl --location --request GET 'http://10.85.128.89:8000/wujie/wms/pick/inner/task/releasePickingTaskStockAndUpdateStatus?&taskPickingNo=%s' \\\n" +
            "--header 'warehouse-code: 30-135-000005'";

    public static void main(String[] args) {
        List<String> kmmz = FileUtil.readLines(FileUtil.newFile("/Users/youyi/Desktop/w1.txt"), "UTF-8");

        for (String string : kmmz) {
            String[] split = Strings.split(string, ",");
            System.out.println(split[0]);
        }


    }
}
