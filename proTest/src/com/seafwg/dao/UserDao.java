package com.seafwg.dao;

import com.seafwg.domain.User;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public interface UserDao {
    User findUserByUserNameAndPassword(User loginUser);
}
