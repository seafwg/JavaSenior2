package com.seafwg.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seafwg.domain.Province;
import com.seafwg.service.impl.ProvinceServiceImpl;

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
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①直接调用service层的查询方法：
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        List<Province> allProvince = provinceService.findAllProvince();
        //②序列化list为json对象：
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(allProvince);
        System.out.println(json);
        //③返回到客户端
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
