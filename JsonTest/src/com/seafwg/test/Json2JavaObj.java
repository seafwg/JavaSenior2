package com.seafwg.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seafwg.domain.Person;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: JSON数据和Java对象之间互相转换：
 * TODO
 * 1. JSON转为Java对象
 * 	  1. 导入jackson的相关jar包
 * 	  2. 创建Jackson核心对象 ObjectMapper
 * 	  3. 调用ObjectMapper的相关方法进行转换
 * 		 1. readValue(json字符串数据,Class)
 * 		    ①json:js对象类型
 * 		    ②Class:将要转换的Java类对象的类：Person.class
 **/
public class Json2JavaObj {

    /**
     * JSON字符串转为Java对象
     */
    @Test
    public void test1() throws IOException {
        //①定义JavaScript对象类型：
        String json = "{\"name\":\"seafwg\",\"age\":23,\"gender\":\"男\"}";
        //②创建ObjectMapper对象：
        ObjectMapper mapper = new ObjectMapper();
        //③转换为Java对象的person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);//Person{name='seafwg', age=23, gender='男', birthday=null}
    }
}
