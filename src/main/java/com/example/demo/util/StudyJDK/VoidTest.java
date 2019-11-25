package com.example.demo.util.StudyJDK;

/**
 * @program: demo
 * @description: description  Void的作用和用法
 * @author: youyi
 * @create: 2019-10-14 09:58
 **/
public class VoidTest {
    public void foo() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 可以用于判断某个方法的返回值是否为void
        if (new VoidTest().getClass().getMethod("foo").getReturnType() == Void.TYPE) {
            System.out.println(true);
        }

    }

    // 也可用在泛型中，如需要一个返回值为void的泛型。
    abstract class Foo<T> {
        abstract T bar();
    }
    class Bar extends Foo<Void> {
        Void bar() {
            return (null);
        }
    }


    // 还可用在形参中，仅仅表示占位

}
