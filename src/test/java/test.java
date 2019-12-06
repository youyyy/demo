public class test {
    private int a;
    private String name;
    test(int a){
        this.a = a;
    }
    test(int a,String name){
        this(a);
        this.name = name;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(fun());
        fun2();
    }

    public static void fun2() throws Exception {
        try {
            throw new Exception();
        }finally {
            System.out.println("asdasds");
        }
    }
    public static int fun(){
        int a;
        try {
            a=1;
            return a;
        }finally {
            a = 2;
            System.out.println(a);
        }
    }
}
