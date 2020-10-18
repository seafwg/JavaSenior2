package com.sefwg.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 记住上一次访问时间
 * TODO
 * 1.需求：
 *     1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 *     2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 * 2. 分析：
 * 	    1. 可以采用Cookie来完成
 * 		2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 			 1. 有：不是第一次访问
 * 				 1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 * 				 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 			 2. 没有：是第一次访问
 * 				 1. 响应数据：您好，欢迎您首次访问
 * 				 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 **/
@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①设置编码
        response.setContentType("text/html;charset=utf-8");
        //②获取所有的Cookie[]
        Cookie[] cookies = request.getCookies();
        //遍历cookies查找cookie中是否存在lastTime的cookie
        boolean hasFirstLoginCookie = true;
        if(cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)) {
                    //不是第一次访问：重新更新cookie的时间
                    hasFirstLoginCookie = false;
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String curDate = simpleDateFormat.format(date);
                    //设置URL编码
                    curDate = URLEncoder.encode(curDate, "utf-8");
                    //设置当前的时间
                    cookie.setValue(curDate);
                    cookie.setMaxAge(30*24*60*60);
                    //响应更新的cookie
                    response.addCookie(cookie);


                    //响应数据部分
                    String value = cookie.getValue();
                    //URL解码
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");
                }
            }
        }

        if(hasFirstLoginCookie == true || cookies == null || cookies.length == 0) {
            // 第一次登录，设置cookie和时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String firstLoginDate = simpleDateFormat.format(date);
            //格式进行URL编码：Cookie支持中文但是有空格会解析成十六进制乱码
            firstLoginDate = URLEncoder.encode(firstLoginDate, "utf-8");
            Cookie cookie = new Cookie("lastTime",firstLoginDate);
            //设置Cookie存活时间为一个月
            cookie.setMaxAge(30*24*60*60);
            response.addCookie(cookie);
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
