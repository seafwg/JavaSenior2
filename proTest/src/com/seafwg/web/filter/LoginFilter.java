package com.seafwg.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: Filter的使用
 * TODO
 * 	 1. 访问案例的资源。验证其是否登录
 * 	 2. 如果登录了，则直接放行。
 * 	 3. 如果没有登录，则跳转到登录页面，提示"您尚未登录，请先登录"。
 **/
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //①获取资源路径：ServletRequest对象并没有getRequestURI()方法
        //强制转换：
        HttpServletRequest request = (HttpServletRequest) req;
        //②获取请求资源的路径
        String URI = request.getRequestURI();
        if(URI.contains("/login.jsp") || URI.contains("/loginServlet") ||
                URI.contains("/css/") || URI.contains("/js/") || URI.contains("/fonts/") ||
                URI.contains("/checkCodeServlet")) {
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
