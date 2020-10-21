package com.seafwg.service;

import com.seafwg.domain.UserInfo;

import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public interface UserInfoService {
    /**
     * 查询所有用户信息：
     * @return
     */
    public List<UserInfo> findAll();
}
