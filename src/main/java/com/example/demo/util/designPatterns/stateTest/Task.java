package com.example.demo.util.designPatterns.stateTest;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-10-16 16:55
 **/
public class Task {
    private int id;
    private String name;
    private Event event;

    public Task(int id, String name, Event event) {
        this.id = id;
        this.name = name;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", event=" + event +
                '}';
    }
}
