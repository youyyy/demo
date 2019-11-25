package reflection;

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
    }
}
