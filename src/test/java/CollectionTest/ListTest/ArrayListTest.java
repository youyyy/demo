package CollectionTest.ListTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) throws IOException {
        /**
         * 动态数组
         */
        /*List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        File file = new File("src/main/resources/txt/test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(list);*/
        Integer a = new Integer(2);
        Integer b = new Integer(1);
        System.out.println(a>b);
    }
}
