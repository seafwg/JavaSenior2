package com.seafwg.proxy;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 代理对象和真实对象实现相同的接口
 * TODO
 **/
public interface SaleComputer {
    //买电脑
    public String sale(Double money);
    //显示电脑
    public void show();
}
