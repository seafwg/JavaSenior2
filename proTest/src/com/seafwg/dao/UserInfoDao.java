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

    //根据id查询用户记录
    public UserInfo findUserInfoById(int id);

    //修改更新数据
    public void updateUserInfo(UserInfo userInfo);

    //添加一条用户信息
    void addUserInfo(UserInfo userInfo);
}
