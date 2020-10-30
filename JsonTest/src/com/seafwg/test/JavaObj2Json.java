package com.seafwg.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seafwg.domain.Person;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: Java对象转换为JSON数据类型
 * TODO
 * 1.转换类型：
 *    ①JSON字符串：
 *    ②转换List集合：
 *    ③转换Map对象
 * 2.转换方法：
 *   writeValueAsString(obj):将对象转为json字符串
 *   writeValue(参数1,obj):
 *     参数1：
 *      File:将obj对象转换为JSON字符串，并保存到指定的文件中
 *      Writer:将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
 *      OutputStream:将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
 **/
public class JavaObj2Json {
    /**
     * Java对象转为JSON字符串
     */
    @Test
    public void test() throws IOException {
        //①创建Person对象：
        Person person = new Person();
        person.setName("seafwg");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());
        //②创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //③调用方法转换mapper.writeValueAssString(obj);
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
        //{"name":"seafwg","age":23,"gender":"男","birthday":1604046776381}
        //@JsonIgnore注解添加在类的属性上表示忽略该属性
        //{"name":"seafwg","age":23,"gender":"男"}
        //@JsonFormat(pattern="yyyy-MM-dd")
        //{"name":"seafwg","age":23,"gender":"男","birthday":"2020-10-30"}
        mapper.writeValue(new FileWriter("d://b.txt"), json);
    }

    /**
     * Java对象转换为List集合：
     */
    @Test
    public void test2() throws IOException {
        //①创建Java对象：
        Person person1 = new Person("seafwg", 23, "男", new Date());
        Person person2 = new Person("张婷怡", 13, "女", new Date());
        Person person3 = new Person("张锦琦", 1, "男", new Date());
        //②创建list集合，装载对象
        List<Person> list = new ArrayList<Person>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        //③创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //④调用writeValueAsString()转换
        mapper.writeValueAsString(list);
        //⑤写出数据
        mapper.writeValue(new FileWriter("d://a.txt"), list);
    }

    /**
     * Java对象转换为Map对象1
     */
    @Test
    public void test3() throws IOException {
        //①创建map对象
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","seafwg");
        map.put("age",23);
        map.put("gender","男");
        //②转换：
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        mapper.writeValue(new FileWriter("d://c.txt"), json);
    }

    /**
     * Java对象转换为Map对象2
     */
    @Test
    public void test4() throws IOException {
        //①创建对象
        Person person1 = new Person("seafwg", 23, "男", new Date());
        Person person2 = new Person("张婷怡", 13, "女", new Date());
        Person person3 = new Person("张锦琦", 1, "男", new Date());
        //②创建Map对象
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("per1",person1);
        map.put("per2",person2);
        map.put("per3",person3);
        //③转换
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new FileWriter("d://d.txt"), map);
    }
}
