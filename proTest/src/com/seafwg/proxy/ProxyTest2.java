package com.seafwg.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 * 代理对象的增强：
 * 1.增强参数
 * 2.增强返回值
 * 3.增强业务逻辑[函数体]
 **/
public class ProxyTest2 {
    public static void main(String[] args) {
        //创造真实对象：
        Lenovo lenovo = new Lenovo();
        //授权动态代理lenovo对象，并增强代理对象
        /**
         * 三个参数：
         *  1. 类加载器：真实对象.getClass().getClassLoader()
         *  2. 接口数组：真实对象.getClass().getInterfaces()
         *  3. 处理器：new InvocationHandler() 匿名函数
         */
        //强制转换成SaleComputer类型
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
            lenovo.getClass().getInterfaces(), new InvocationHandler() {
                /**
                 * 代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                 * @param proxy 代理对象
                 * @param method 代理对象调用的方法，被封装的对象
                 * @param args 代理对象调用方法时，传递的参数
                 * @return
                 * @throws Throwable
                 **/
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(method.getName().equals("sale")) {
                        //①增强参数：
                        double money = (double) args[0];
                        money *= 0.85;
                        //③方法增强：
                        System.out.println("提供免费体验15天...");
                        System.out.println("sale方法执行了...");
                        String invoke = (String) method.invoke(lenovo, (double) money);
                        //②增强返回值
                        return invoke+"_赠送鼠标垫+电脑包";
                    }else{
                        Object invoke = method.invoke(lenovo, args);
                        return invoke;
                    }
                }
            });
        //proxy_lenovo.show();
        //调用sale方法：接收代理逻辑返回值
        String sale_computer = proxy_lenovo.sale((double) 8000);
        System.out.println(sale_computer);
    }
}
