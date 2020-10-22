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
    //查询所有用户信息
    public List<UserInfo> findAllUserInfo();

    //根据id删除数据
    public void delUserInfoById(int id);
}
