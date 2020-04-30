package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        User user = User.Builder.anUser()
                .userId("001")
                .userName("游移")
                .passWord("001")
                .level("7")
                .tellphone("110")
                .build();
        /**反射*/
        Class ob = user.getClass();
        User u = (User) ob.newInstance();
        System.out.println(u);

        Student student = new Student();
        student.setSid("1");
        student.setSname("wu");

        System.out.println("========================");

        Student student1 = student.clone();
        System.out.println(student1);
        System.out.println("=======================");

        try {
            Method method = Student.class.getDeclaredMethod("setSname", String.class);
            method.setAccessible(true);
            method.invoke(student1,"youyi");

            Field field = Student.class.getDeclaredField("sname");

            System.out.println(student1);

            field.setAccessible(true);
            System.out.println(field.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
