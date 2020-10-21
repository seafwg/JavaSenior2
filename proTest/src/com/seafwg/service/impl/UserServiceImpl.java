package com.seafwg.service.impl;

import com.seafwg.dao.impl.UserDaoImpl;
import com.seafwg.domain.User;
import com.seafwg.service.UserService;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class UserServiceImpl implements UserService {
    //申明调用dao层实现的方法：
    private UserDaoImpl userDao = new UserDaoImpl();

    /**
     * 调用UserDaoImpl登录方法：
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findUserByUserNameAndPassword(user);
    }
}
