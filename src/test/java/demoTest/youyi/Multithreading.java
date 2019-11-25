package demoTest.youyi;

/**
 * Created by yi.you on 2018/8/3.
 */
public class Multithreading implements Runnable{
    private String name;
    public Multithreading(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(name + i);
        }
    }
}

class test{//多线程
    public static void main(String[] args){
        new Thread(new Multithreading("a")).start();
        new Thread(new Multithreading("b")).start();
    }
}
