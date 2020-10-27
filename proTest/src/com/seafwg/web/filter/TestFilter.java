package com.seafwg.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: Filter的使用
 * TODO
 * 需求：
 * 	 1. 访问案例的资源。验证其是否登录
 * 	 2. 如果登录了，则直接放行。
 * 	 3. 如果没有登录，则跳转到登录页面，提示"您尚未登录，请先登录"。
 **/
@WebFilter("/testFilter")
public class TestFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
