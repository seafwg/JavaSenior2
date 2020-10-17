package com.seafwg.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //①.创建一对象，在内存中图片(验证码图片对象)
        /**
         * Image是一个抽象类，BufferedImage是其实现类，是一个带缓冲区图像类，主要作用是将一幅图片加载到内存中
         * 提供获得绘图对象、图像缩放、选择图像平滑度等功能，通常用来做图片大小变换、图片变灰、设置透明不透明等。
         */
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //②.美化图片
        //Graphics是Java绘图的核心类，它可以支持两种绘图：一种是基本的绘图，如画线、矩形、圆等；另一种是画图像，主要用于动画制作
        Graphics graphics = image.getGraphics();
        //2.1填充颜色和背景
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);
        //2.2画边框
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0,0,width-1,height-1);
        
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符串
            char ch = str.charAt(index);//随机数
            //2.3写验证码
            graphics.drawString(ch+"",width/5*i,height/2);
        }
        //2.3框内画条线
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }


        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
