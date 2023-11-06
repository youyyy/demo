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

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2021/9/15
 **/
public class FileUtils {
    private static String txt = "curl -X \"POST\" \"http://gateway.tanjiu.cn/wf//lyfw/backdoor/reduceBenefit\" \\\n" +
            "-H 'token: openApi' \\\n" +
            "-H 'Content-Type: application/json' \\\n" +
            "-d '{  \"serialNumberAndMoney\": [    \"%s\"  ]}' \\";

    public static void main(String[] args) {
        List<String> kmmz = FileUtil.readLines(FileUtil.newFile("/Users/youyi/Desktop/11.txt"), "UTF-8");
        File file = FileUtil.newFile("/Users/youyi/Desktop/11test.sh");

        for (String string : kmmz) {
            FileUtil.appendString(String.format(txt,string),file,"UTF-8");
            FileUtil.appendString("\n",file,"UTF-8");
            FileUtil.appendString("\n",file,"UTF-8");
        }


    }
}
