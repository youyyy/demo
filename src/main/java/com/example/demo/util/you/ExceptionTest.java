package com.example.demo.util.you;

/**
 * @program: demo
 * @description: description学习异常的处理方式
 * @author: youyi
 * @create: 2019-09-22 11:57
 **/
public class ExceptionTest {
    public static void main(String[] args) throws Exception {
        System.out.println(test());

        int a = 3;
        System.out.println(++a);
    }
    public static int test() throws Exception{

        try {
            if (9>1){
                throw new Exception();
            }
            System.out.println("after exception");
            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }finally {
            System.out.println("youyi");
        }
    }
}
