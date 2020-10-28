## 增强对象的功能：
### 设计模式：一些通用的解决固定问题的方式
#### 1. 装饰模式
#### 2. 代理模式
##### 概念：
>1. 真实对象：被代理的对象
>2. 代理对象：
>3. 代理模式：代理对象代理真实对象，达到增强真实对象功能的目的
##### 实现方式：
>1. 静态代理：有一个类文件描述代理模式
>2. 动态代理：在内存中形成代理类
>> 2.1 实现步骤：
>>> 1. 代理对象和真实对象实现相同的接口
>>> 2. 代理对象 = Proxy.newProxyInstance();
>>> 3. 使用代理对象调用方法。
>>> 4. 增强方法     
>> 2.2 增强方式：
>>> 1. 增强参数列表
>>> 2. 增强返回值类型
>>> 3. 增强方法体执行逻辑	
### 动态代理case描述：
电脑生产商，电脑代理销售商，买卖电脑之间的关系：

电脑生厂商：生产商生产电脑，也能销售
电脑代理销售商：某地的代理商或者网络平台
买电脑的用户：参与买卖

用户在实体店或者网络平台买电脑的过程：代理商代理制造商参与买卖，代理商中间参与电脑的一些服务。
代理商在中间有附加的一些服务。

### 代理模式-动态代理：
```java
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

```              