package bishi;

public class Test {
    public static final int a = 9;
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        System.out.println(a==b);
        System.out.println("==========");

        System.out.println(A.a);

        System.out.println("==========");

        System.out.println(B.a);
    }
}
class A{
    public static final int a = 9;
    static{
        System.out.println("A");
    }
}
class B extends A{
    static{
        System.out.println("B");
    }
}