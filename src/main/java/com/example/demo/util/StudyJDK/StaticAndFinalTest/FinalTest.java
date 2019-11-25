package com.example.demo.util.StudyJDK.StaticAndFinalTest;

/**
 * @program: demo
 * @description: description  对final关键字的描述
 * @author: youyi
 * @create: 2019-10-06 10:46
 **/
// 当用final修饰一个类时，表明这个类不能被继承。也就是说，如果一个类你永远不会让他被继承，就可以用final进行修饰。
// final类中的成员变量可以根据需要设为final，但是要注意final类中的所有成员方法都会被隐式地指定为final方法。
public final class FinalTest {
    // final成员变量表示常量，只能被赋值一次，赋值后值不再改变。
    private final int a = 1;
    // final成员变量表示常量，只能被赋值一次，赋值后值不再改变。
    private final static int b = 1;

        public static void main(String[] args) {

    }

    // 使用final方法的原因有两个。
    // 第一个原因是把方法锁定，以防任何继承类修改它的含义；
    // 第二个原因是效率。在早期的Java实现版本中，会将final方法转为内嵌调用。但是如果方法过于庞大，可能看不到内嵌调用带来的任何性能提升。
    // 在最近的Java版本中，不需要使用final方法进行这些优化了
    final void fun(){
        System.out.println("我是final方法");
    }
}
