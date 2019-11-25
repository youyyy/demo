package com.example.demo.util.designPatterns.stateTest;

import com.example.demo.util.designPatterns.stateTest.state.State;

/**
 * @program: demo
 * @description: 上下文
 * @author: youyi
 * @create: 2019-10-16 16:47
 **/
public class Context {
    State state;
    private volatile Task task;
    public Context(){}

    public Context(State state,Task task) {
        this.state = state;
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setState(State state) {
        // 前一个状态 和下一个状态具体操作都可以实现
        this.state = state;
        // 将task的state改了
        this.task.setEvent(state.getStatus());
    }

    public State getState() {
        return state;
    }

    public void doding(Event event) {
        // 公有操作
        getTask().setName("游移测试一下能不能修改");


        state.doing(this,event);
    }


}
