package demoTest;

public class Single {
    //内部类实现单例
    public final static String name = "youyi";
    private Single(){}
    private static class SingleHolder{
        private static final Single instance = new Single();
    }
    public static Single getInstance(){
        return SingleHolder.instance;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println(Single.getInstance().name);
        });
        thread.start();
    }

}
