package com.example.demo.util.MeicaiDoUtil.redistest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @Author youyi
 * @Date 2019/9/4 下午9:30
 **/
public class QueueTest {

    private static final String name = "queue";
    private static Jedis con = JedisPoolTest.getJedis();
    private static Queue<String> queue = new LinkedList<>();

    public static void addToDeplayQueue(Task task) {
        System.out.println(task.getName() + "----------已经从延时队列中转至队列----" + "当前时间:" + System.currentTimeMillis());
        con.zadd(name, task.getTime(), task.getName());
    }

    public void addToTaskQue(String name) {
        queue.add(name);
        System.out.println(name + "已经从延时队列中转至队列" + "当前时间:" + System.currentTimeMillis());
    }

    public void domain() {
        while (true){
            Set<Tuple> item = con.zrangeWithScores(name, 0, 0);
            if (item != null && !item.isEmpty()) {
                Tuple tuple = item.iterator().next();
                if (System.currentTimeMillis() >= tuple.getScore()) {
                    // 从延时队列中移除
                    con.zrem(name, tuple.getElement());
                    //进入执行队列
                    addToTaskQue(tuple.getElement());
                }
            }
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Long now = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Task task = Task.builder()
                    .name(System.currentTimeMillis() + "任务")
                    .time(now + new Random().nextLong() % 1000).build();
            addToDeplayQueue(task);
            Thread.sleep(100);
        }
        new QueueTest().domain();

    }

}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Task {
    private String name;
    private Long time;
}