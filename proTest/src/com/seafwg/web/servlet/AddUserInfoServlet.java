package com.seafwg.web.servlet;

import com.seafwg.domain.UserInfo;
import com.seafwg.service.impl.UserInfoServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
@WebServlet("/addUserInfoServlet")
public class AddUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①设置编码：
        request.setCharacterEncoding("utf-8");
        //②获取参数封装对象
        System.out.println("==========");
        Map<String, String[]> map = request.getParameterMap();
        UserInfo userInfo = new UserInfo();
        try {
            BeanUtils.populate(userInfo, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //③调用service
        UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
        userInfoService.addUserInfo(userInfo);
        //④跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/findUserInfoByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
