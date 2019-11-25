package com.example.demo.util.designPatterns.stateTest.state;

import com.example.demo.util.designPatterns.stateTest.Context;
import com.example.demo.util.designPatterns.stateTest.Event;
import com.example.demo.util.designPatterns.stateTest.Manager;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-16 16:49
 **/
public class StateA extends AbstractState {
    private static final Event event = Event.FIRST_CHECK;

    @Override
    public void doing(Context context,Event event) {
        // 修改状态模式的状态   分类
        switch (event) {
            // 私有操作
            case INIT:
                // 对不同的state，私有操作
                context.setState(Manager.stateB);
                break;
            case FIRST_CHECK:
                context.setState(Manager.stateA);
                break;
        }
        context.getTask().setEvent(event);
    }

    @Override
    public Event getStatus() {
        return event;
    }
}
