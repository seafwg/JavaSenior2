package com.seafwg.jedis.test;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: jedis Demo:
 * TODO
 * 一 Jedis使用步骤：
 * ①下载jedis的jar包
 *   jedis.jar和commons-pool
 * ②使用:
 *   1. 获取连接
 *   2. 操作
 *   3. 关闭连接
 **/
public class JedisTest {
    /**
     * Jedis操作字符串：
     * 基本方法：
     * set/get/del
     */
    @Test
    public void test1() {
        //①获取链接
        Jedis jedis = new Jedis();
        //②基本操作
        String s = jedis.set("name", "seafwg");
        System.out.println(s);
        //③关闭连接
        jedis.close();
    }

    /**
     * Jedis操作hash:
     * 基本放方法：
     * hset/hget/hdel
     */
    @Test
    public void test2() {
        //①获取连接
        Jedis jedis = new Jedis();
        //②基本操作
        jedis.hset("user","name","seafwg");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","男");
        //jedis.hdel("user","gender");
        //获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        //map集合的遍历：
        Set<String> keySet= user.keySet();
        for (String key : keySet) {
            String value = user.get(key);
            System.out.println(key+":"+value);
        }
        //③关闭连接
        jedis.close();
    }

    /**
     * Jedis操作List
     * lpush/rpush
     * lpop/rpop
     * lrange
     */
    @Test
    public void test3() {
        //①建立连接
        Jedis jedis = new Jedis();
        //②基本操作
        jedis.lpush("myList","a");
        jedis.rpush("myList","b");

        List<String> myList = jedis.lrange("myList", 0, -1);
        System.out.println(myList);
        //③关闭连接
        jedis.close();
    }

    /**
     * Jedis操作set
     * sadd/smembers/srem
     */
    @Test
    public void test4() {
        Jedis jedis = new Jedis();
        jedis.sadd("mySet","a");
        jedis.sadd("mySet","b");
        Set<String> set = jedis.smembers("mySet");
        System.out.println(set);
        jedis.close();
    }

    /**
     * Jedis操作sortedset
     * zadd/zrange/zrem
     */
    @Test
    public void test5() {
        Jedis jedis = new Jedis();
        jedis.zadd("mySortedSet",80,"seafwg");
        jedis.zadd("mySortedSet",90,"zhangtingyi");
        Set<String> mySortedSet = jedis.zrange("mySortedSet", 0, -1);
        System.out.println(mySortedSet);
        jedis.close();
    }
}
