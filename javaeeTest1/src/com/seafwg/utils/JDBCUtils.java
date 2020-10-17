package com.seafwg.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: Druid数据库连接池工具类
 * TODO
 **/
public class JDBCUtils {

    private static DataSource ds;

    //①初始化Druid连接池对象
    static {
        try {
            //读取配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //初始化连接对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ②获取连接池对象
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * ③获取连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
