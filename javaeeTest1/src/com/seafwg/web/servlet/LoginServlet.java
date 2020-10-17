package com.seafwg.web.servlet;

import com.seafwg.dao.UserDao;
import com.seafwg.domain.User;
import org.apache.commons.beanutils.BeanUtils;

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
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //①设计编码
        request.setCharacterEncoding("utf-8");
        //②获取请求参数
        Map<String, String[]> map = request.getParameterMap();
        //③创建User对象
        User loginUser = new User();
        //使用BeanUtils封装请求数据
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //④调用UserDao的登录方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        if (user == null) {
            //登录失败转发
            request.getRequestDispatcher("/failServlet").forward(request,response);
        } else {
            //存储数据
            request.setAttribute("loginUser", user);
            //登录成功转发
            request.getRequestDispatcher("successServlet").forward(request,response);
        }
    }
}
