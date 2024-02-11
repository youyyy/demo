package com.example.demo.util.StudyJDK.ioANDnio;
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


import java.io.*;
import java.util.Arrays;

/**
 * @program: demo
 * @description: java读写文件 字节流，建议用于音频图像。。用于字符可能会出现编码问题（如中文）
 * @author: youyi
 * @create: 2020-05-22 19:44
 **/
public class IOTest {
    public static void main(String[] args) {
//        writeTxt("/Users/youyi/IdeaProjects/demo/src/main/java/com/example/demo/util/StudyJDK/ioANDnio/a.txt","hhh");
//        String s = readTxt("/Users/youyi/IdeaProjects/demo/src/main/java/com/example/demo/util/StudyJDK/ioANDnio/a.txt");
//        System.out.println(s);

        String s = readTxt("/Users/youyi/Desktop/11.txt");
        String[] numbers = s.split("\n");
        Arrays.stream(numbers).forEach(System.out::println);
    }


    public static void writeTxt(String txtPath, String content) throws IOException {

        File file = new File(txtPath);
        if (file.exists()) {
            //判断文件是否存在，如果不存在就新建一个txt
            file.createNewFile();
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)) {
            bos.write(content.getBytes());
            bos.flush();
        } catch (IOException e) {

        }
    }

    public static String readTxt(String txtPath) {
        File file = new File(txtPath);
        if (file.isFile() && file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

                StringBuffer sb = new StringBuffer();
                String text = null;
                while ((text = bufferedReader.readLine()) != null) {
                    sb.append(text);
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
