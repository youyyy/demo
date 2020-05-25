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

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-05-25 10:43
 **/

import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @program: demo
 * @description: NIO 读写
 * @author: youyi
 * @create: 2020-05-25 10:07
 **/
public class FileUtil {


    /**
     * 读取文件
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> readAlllines(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    /**
     * append写 每个line写一行, 如果没有该path , 会创建一个
     *
     * @param path
     * @param lines
     */
    public static void writeAppend(Path path, List<String> lines) throws IOException {
        if (!Files.exists(path))
            Files.createFile(path);

        if (!CollectionUtils.isEmpty(lines)) {
            lines.forEach(line -> {
                try {
                    Files.write(path, "\n".getBytes(Charset.forName("UTF-8")), StandardOpenOption.APPEND);
                    Files.write(path, line.getBytes(Charset.forName("UTF-8")), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
