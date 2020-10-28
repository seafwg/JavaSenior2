package com.seafwg.proxy;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 * 真实类：
 **/
public class Lenovo implements SaleComputer{
    @Override
    public String sale(Double money) {
        System.out.println("花了"+money+"买了一台联想电脑...");
        return "Lenovo";
    }

    @Override
    public void show() {
        System.out.println("展示电脑...");
    }
}
