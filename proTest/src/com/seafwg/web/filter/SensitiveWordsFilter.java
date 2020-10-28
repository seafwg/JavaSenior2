package com.seafwg.web.filter;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 敏感词汇过滤器
 * TODO
 * ①在过滤器的初始化方法中加载敏感词汇
 * ②在doFilter方法中对getParameter方法进行增强：
 *  1.获取返回值数据
 *  2.对数据进行比较，替换
 **/
@WebFilter("/aaaaa")
public class SensitiveWordsFilter implements Filter {
    //定义敏感词汇集合：
    private List<String> list = new ArrayList<String>();
    /**
     * init初始化函数加载初始资源配置：
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            //①获取文件真实路径：filterConfig获取servletContext对象
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/sensitiveword.txt");
            //②读取文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            //③将文件的词汇以行为单位添加到list集合中
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增强getparameter方法：
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(),
            servletRequest.getClass().getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    //增强方法：getParameter方法
                    if(method.getName().equals("getParameter")) {
                        //获取返回值，对返回值进行修改
                        String value = (String) method.invoke(servletRequest, objects);
                        if(value != null) {
                            for (String str : list) {
                                if(value.contains(str)) {
                                    value = value.replaceAll(str, "***");
                                }
                            }
                        }
                        return value;
                    }
                    return method.invoke(servletRequest,objects);
                }
            });
        //放行：放行增强后的req域对象
        filterChain.doFilter(proxy_req, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
