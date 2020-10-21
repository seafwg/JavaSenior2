package com.seafwg.dao;

import com.seafwg.domain.UserInfo;

import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public interface UserInfoDao {
    public List<UserInfo> findAllUserInfo();
}
