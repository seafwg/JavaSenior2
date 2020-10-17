package com.seafwg.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 图片下载
 * TODO
 * ①主要功能设置响应头数据：
 *  由于正常的响应头Mime类型：大类型/小类型：“text/html” eg:image/jpeg等都是被浏览器解析的，正常解析就会直接打开，浏览器渲染显示。
 *  设置响应头的Mime类型："content-type"为对应的Mime类型[this.getServletContext().getMimeType(filename)]
 *  设置响应头打开方式："content-disposition":"attachment;filename="+filename
 * ②流程分析：
 *  1.获取文件参数：名称
 *  2.把资源文件加载到内存
 *  3.设置响应头信息
 *  4.写入响应的数据
 *  5.关闭输入流
 *
 **/
@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①获取参数，文件名称
        String filename = request.getParameter("filename");
        //②使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2建立传输渠道用字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //③设置相应头
        //3.1设置响应头类型：content-type
        //servletContext.getMimeType(filename)获取文件对应的mime类型：
        response.setHeader("content-type",servletContext.getMimeType(filename));
        //3.2设置相应头打开方式：content-disposition
        response.setHeader("content-disposition","attachment;filename="+filename);

        //4.将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buf = new byte[1024 * 8];
        int len;
        while((len = fileInputStream.read(buf) )!= -1) {
            outputStream.write(buf,0,len);
        }

        fileInputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
