package com.seafwg.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: JedisPool jedis连接池
 * TODO
 * 通过JedisPool连接池封装JedisUtils工具类
 **/
public class JedisUtils {
    //①声明JedisPool连接池
    private static JedisPool jedisPool;
    //②初始化JedisPool
    static {
        //读取文件
        InputStream ras = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //加载文件：
        Properties pro = new Properties();
        try {
            pro.load(ras);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，并且设置到JedisPoolConfig中
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
        //初始化JedisPool连接
        jedisPool = new JedisPool(jedisPoolConfig, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }

    //③获取连接方法
    public static Jedis getJedis() {
        //从jedisPool中返回一个资源
        return jedisPool.getResource();
    }
}
