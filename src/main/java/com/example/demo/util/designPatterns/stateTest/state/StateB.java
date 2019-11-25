package com.example.demo.util.designPatterns.stateTest.state;

import com.example.demo.util.designPatterns.stateTest.Context;
import com.example.demo.util.designPatterns.stateTest.Event;
import com.example.demo.util.designPatterns.stateTest.Manager;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-16 17:07
 **/
public class StateB extends AbstractState {
    private static final Event event = Event.SECOND_CHECK;

    @Override
    public void doing(Context context, Event event) {
        switch (event) {
            case SECOND_CHECK:
                break;
            default:
                throw new RuntimeException("yichang");
        }
        context.getTask().setEvent(event);
    }

    @Override
    public Event getStatus() {
        return event;
    }
}
