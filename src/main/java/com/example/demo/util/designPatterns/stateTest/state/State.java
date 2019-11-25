package com.example.demo.util.designPatterns.stateTest.state;

import com.example.demo.util.designPatterns.stateTest.Context;
import com.example.demo.util.designPatterns.stateTest.Event;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-16 16:46
 **/
public interface State {

    void doing(Context context,Event event);

    // 状态本身是一个属性，这里获取自身的特定属性
    Event getStatus();

}
