package ThreadPool;

public class ThreadTest implements Runnable{
    @Override
    public void run() {
        System.out.println(1);
    }
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("asd");
        }).start();
        Thread a = new Thread(new ThreadTest());
        a.start();
    }


}
