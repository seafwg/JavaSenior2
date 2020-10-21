package com.seafwg.service;

import com.seafwg.domain.User;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public interface UserService {
    /**
     * 用户登录接口
     * @param user
     * @return
     */
    User login(User user);
}
