package com.seafwg.test;

import com.seafwg.dao.UserDao;
import com.seafwg.domain.User;
import org.testng.annotations.Test;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class UserDaoTest {
    @Test
    public void userDaoTest() {
        //创建User对象
        User user = new User();
        user.setUsername("com/seafwg");
        user.setPassword("123123");

        //调用UserDao
        UserDao userDao = new UserDao();
        User loginFlag = userDao.login(user);

        System.out.println(loginFlag);
    }
}
