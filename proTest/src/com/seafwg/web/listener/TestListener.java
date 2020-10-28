package com.seafwg.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: Listener练习：
 * TODO
 * 步骤：
 * 	 1. 定义一个类，实现ServletContextListener接口
 * 	 2. 复写方法
 *   3. 配置
 *      ①<listener>
 *  		<listener-class>com.seafwg.web.listener.TestListener</listener-class>
 *  	  </listener>
 *        * 指定初始化参数<context-param>
 *      ②注解@WebListener
 *
 **/
@WebListener
public class TestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
