package com.seafwg.test;

import com.seafwg.dao.impl.UserDaoImpl;
import com.seafwg.domain.User;
import com.seafwg.service.impl.UserServiceImpl;
import org.testng.annotations.Test;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class UserTest {

    /**
     * 登录测试：UserDaoImpl
     */
    @Test
    public void UserLoginUserDaoTest() {
        User user = new User();
        user.setName("admin");
        user.setPassword("seafwg");

        UserDaoImpl userDao = new UserDaoImpl();
        User loginUser = userDao.findUserByUserNameAndPassword(user);
        System.out.println(loginUser);
    }

    /**
     * 登陆测试：UserServiceImpl
     */
    @Test
    public void UserLoginServiceTest() {
        User user = new User();
        user.setName("admin");
        user.setPassword("seafwg");

        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.login(user);
        System.out.println(login);
    }
}
