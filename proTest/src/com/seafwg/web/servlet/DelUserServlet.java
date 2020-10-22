package com.seafwg.web.servlet;

import com.seafwg.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①获取参数id
        String id = request.getParameter("id");
        //②调用service方法
        UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
        userInfoService.delUserInfo(id);
        //③页面跳转到findUserInfoByPageServlet
        response.sendRedirect(request.getContextPath()+"/findUserInfoByPageServlet");
        // 思考：重定向和转发的区别
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
