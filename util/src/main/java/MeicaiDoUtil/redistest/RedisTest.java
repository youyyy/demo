package MeicaiDoUtil.redistest;

import redis.clients.jedis.Jedis;

/**
 * @Description
 * @Author youyi
 * @Date 2019/9/4 下午7:37
 **/
public class RedisTest {

    public static Jedis connect(){
        Jedis jedis = JedisPoolTest.getJedis();
        return jedis;
    }
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{

        });
        Jedis con = connect();
        con.zadd("name",5,"游移");
        con.zadd("name",6,"小工");
        con.zadd("name",4,"大D");
        con.zadd("name",9,"迪迪");
        con.zadd("name",1,"别别");
        con.zadd("name",28,"小与偶");
        /**
         * 升序
         */
        System.out.println(con.zrange("name",0,-1));
        /**
         * 降序
         */
        System.out.println(con.zrevrange("name",0,-1));

        /**
         * 升序带分
         */
        System.out.println(con.zrangeWithScores("name", 0, -1));


        System.out.println(con.zrangeByScore("name", 5, 10));

        System.out.println(con.zrank("name", "游移"));

        con.close();
    }
}
