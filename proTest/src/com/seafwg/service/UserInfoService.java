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

    /**
     * 删除一行数据id
     * @param id
     */
    public void delUserInfo(String id);

    /**
     * 修改功能：根据id查询用户为id的一条记录
     * @param id
     */
    public UserInfo findUserInfoById(String id);

    /**
     * 修改更新数据
     * @param userInfo
     */
    public void updateUserInfo(UserInfo userInfo);

    /**
     * 添加一条用户信息
     * @param userInfo
     */
    void addUserInfo(UserInfo userInfo);
}
