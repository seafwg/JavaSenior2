package com.seafwg.test;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: JacksonTest基本使用：
 * TODO
 * 步骤：
 *  1. 导入jackson的相关jar包
 * 	2. 创建Jackson核心对象 ObjectMapper
 * 	3. 调用ObjectMapper的相关方法进行转换
 * 	    1. 转换方法：
 * 			 * writeValue(参数1，obj):
 * 		         参数1：
 * 		             File：将obj对象转换为JSON字符串，并保存到指定的文件中
 * 		             Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
 * 		             OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
 * 		     * writeValueAsString(obj):将对象转为json字符串
 **/
public class JacksonTest {
}
