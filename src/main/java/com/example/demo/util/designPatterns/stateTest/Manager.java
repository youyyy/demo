package com.example.demo.util.designPatterns.stateTest;

import com.example.demo.util.designPatterns.stateTest.state.StateA;
import com.example.demo.util.designPatterns.stateTest.state.StateB;

/**
 * @program: demo
 * @description: 状态模式 根据不同状态进行不同的操作
 * @author: youyi
 * @create: 2019-10-16 16:50
 **/
public class Manager {
    public static StateA stateA = new StateA();
    public static StateB stateB = new StateB();

    public static void change(Task task,Event event){
        Context context = null;
        switch (task.getEvent()){
            case INIT:
                context = new Context(stateA,task);
                break;
            case REJECT:
                context = new Context(stateB,task);
                break;
            case FIRST_CHECK:
                context = new Context(stateB,task);
                // 等等
        }
        context.doding(event);
    }

    //  测试的出发点
    public static void main(String[] args) {
        Task task = new Task(1,"task-test",Event.INIT);
        Manager.change(task,Event.INSTOCK_CLOSE);
        System.out.println(task.toString());
    }
}
