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
 * @describe: XXX
 * TODO
 **/
public class JDBCUtils {
    //声明ds
    private static DataSource ds;
    //1.初始化连接池对象
    static {
        try {
            //read config
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //initial object
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //2.获取连接池对象
    public static DataSource getDataSource() {
        return ds;
    }
    //3.获取连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
