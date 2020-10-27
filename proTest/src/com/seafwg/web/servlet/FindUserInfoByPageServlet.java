package com.seafwg.web.servlet;

import com.seafwg.domain.UserInfo;
import com.seafwg.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
@WebServlet("/findUserInfoByPageServlet")
public class FindUserInfoByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①设置编码
        request.setCharacterEncoding("utf-8");
        //②调用service查询
        UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
        List<UserInfo> allUserInfo = userInfoService.findAll();
        //③将数据存储到request域中：
        request.setAttribute("allUserInfo", allUserInfo);
        //④数据转发
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
