package com.seafwg.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 * Demo: 校验用户名是否存在
 * 		1. 服务器响应的数据，在客户端使用时，要想当做json数据格式使用。有两种解决方案：
 * 			1. $.get(type):将最后一个参数type指定为"json"
 * 			2. 在服务器端设置MIME类型
 * 				response.setContentType("application/json;charset=utf-8");
 **/
@WebServlet("/isExistUserNameServlet")
public class IsExistUserNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①获取用户名：
        String username = request.getParameter("username");
        //②调用service省去...
        //③本地创建一个map对象
        //设置响应的数据格式为json[如果前端未设置数据类型后端可以设置传输的数据类型]
        //response.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<>();
        //假设username:seafwg
        if("seafwg".equals(username)) {
            map.put("userExsit", true);
            map.put("msg", "此用户名太受欢迎，请你更换一个...");
        }else {
            map.put("userExsit", false);
            map.put("msg", "用户名可用");
        }
        //④将map转换为json并传递给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
