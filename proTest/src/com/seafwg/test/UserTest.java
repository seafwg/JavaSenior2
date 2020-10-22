package com.seafwg.test;

import com.seafwg.dao.impl.UserDaoImpl;
import com.seafwg.domain.User;
import com.seafwg.domain.UserInfo;
import com.seafwg.service.impl.UserInfoServiceImpl;
import com.seafwg.service.impl.UserServiceImpl;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class UserTest {

    UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
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

    /**
     * 查询列表显示：
     */
    @Test
    public void findAllUserInfoTest() {
        List<UserInfo> all = userInfoService.findAll();
        for (UserInfo userInfo : all) {
            System.out.println(userInfo);
        }
    }
    /**
     * 根据id删除测试：
     */
    @Test
    public void delUserInfoById() {
        userInfoService.delUserInfo("1");
    }
}
