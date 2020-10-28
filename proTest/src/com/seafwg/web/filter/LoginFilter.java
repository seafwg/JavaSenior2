package com.seafwg.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: Filter的使用
 * 1.步骤：
 *  ①创建一个Filter
 *  ②配置拦截路径：
 *      1.web.xml
 *          <filter>
     * 	        <filter-name>demo1</filter-name>
     * 	        <filter-class>com.seafwg.web.filter.LoginFilter</filter-class>
     * 	    </filter>
     * 	    <filter-mapping>
     * 	        <filter-name>demo1</filter-name>
     * 			<!-- 拦截路径 -->
     * 	        <url-pattern>/*</url-pattern>
     * 	    </filter-mapping>
 *      2.注解@WebFilter("/*")
 * 2.过滤器生命周期方法
 * 		1. init:在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
 * 		2. doFilter:每一次请求被拦截资源时，会执行。执行多次
 * 		3. destroy:在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
 * TODO
 * 	 1. 访问案例的资源。验证其是否登录
 * 	 2. 如果登录了，则直接放行。
 * 	 3. 如果没有登录，则跳转到登录页面，提示"您尚未登录，请先登录"。
 **/
@WebFilter("/bcdef")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //①获取资源路径：ServletRequest对象并没有getRequesturi()方法
        //强制转换：
        HttpServletRequest request = (HttpServletRequest) req;
        //②获取请求资源的路径
        String uri = request.getRequestURI();
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") ||
                uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") ||
                uri.contains("/checkCodeServlet")) {
            //包含，用户就是想登录。放行
            chain.doFilter(req, resp);
        }else {
            //不包含，需要验证用户是否登录
            //③从获取session中获取user[登录的时候向session中保存了user]
            Object user = request.getSession().getAttribute("user");
            if(user != null) {
                //登录了放行
                chain.doFilter(req,resp);
            }else {
                //没有登录。跳转登录页面
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
