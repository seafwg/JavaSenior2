package com.seafwg.web.servlet;

import com.seafwg.domain.UserInfo;
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
@WebServlet("/modifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①获取参数id
        String id = request.getParameter("id");
        //②调用service查询用户id的详细数据回写到update页中
        UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
        UserInfo userInfo = userInfoService.findUserInfoById(id);
        //③将数据保存在request域中
        request.setAttribute("userInfo", userInfo);
        //④转发到update.jsp页面，对数据进行回写到表单中，修改后再次提交保存
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
