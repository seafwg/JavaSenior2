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
}
