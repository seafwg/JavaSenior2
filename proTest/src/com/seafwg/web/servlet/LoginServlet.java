package com.seafwg.web.servlet;

import com.seafwg.domain.User;
import com.seafwg.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1设置编码：
        request.setCharacterEncoding("utf-8");
        //2获取数据：
        //2.1获取验证码进行校验
        String verifyCode = request.getParameter("verifyCode");
        //2.2获取session中的CHECKCODE_SERVER
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //每次获取之后删除session中的checkCode
        session.removeAttribute("CHECKCODE_SERVER");

        //比较
        if (!checkcode_server.equalsIgnoreCase(verifyCode)) {
            //验证码不正确：跳转到登录页，提示错误信息
            request.setAttribute("login_msg","验证码输入错误...");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        //2.3获取用户信息：
//        String name = request.getParameter("name");
        Map<String, String[]> map = request.getParameterMap();
        //封装User对象[使用BeanUtils.populate()]
        User loginUser = new User();
        try {
//            BeanUtils.populate(user,map);
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3调用UserServiceImpl登录方法：
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(loginUser);
        //4判断是否登录成功：
        if (user != null) {
            //登录成功：用户存入session中，页面跳转到index.jsp
            session.setAttribute("user",loginUser);
            //request.getRequestDispatcher("/index.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else {
            //登录失败：提示信息，跳转到登录页面：
            request.setAttribute("login_msg","用户名或密码错误...");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
