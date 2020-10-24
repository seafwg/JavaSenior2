package com.seafwg.service.impl;

import com.seafwg.dao.impl.UserInfoDaoImpl;
import com.seafwg.domain.UserInfo;
import com.seafwg.service.UserInfoService;

import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class UserInfoServiceImpl implements UserInfoService {
    //声明dao层对象：
    UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAllUserInfo();
    }

    /**
     * 根据id删除一行数据
     * @param id
     */
    @Override
    public void delUserInfo(String id) {
        userInfoDao.delUserInfoById(Integer.parseInt(id));
    }

    /**
     * 根据用户id查询记录
     * @param id
     * @return
     */
    @Override
    public UserInfo findUserInfoById(String id) {
        return userInfoDao.findUserInfoById(Integer.parseInt(id));
    }

    /**
     * 修改更新数据
     * @param userInfo
     */
    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUserInfo(userInfo);
    }

    /**
     * 添加用户信息
     * @param userInfo
     */
    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoDao.addUserInfo(userInfo);
    }
}
