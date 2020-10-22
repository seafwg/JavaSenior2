package com.seafwg.dao.impl;

import com.seafwg.dao.UserInfoDao;
import com.seafwg.domain.UserInfo;
import com.seafwg.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class UserInfoDaoImpl implements UserInfoDao {
    //声明JdbcTemplate
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<UserInfo> findAllUserInfo() {
        //定义sql:
        String sql = "SELECT * FROM userinfo";
//        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        List<UserInfo> userInfo = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
        return userInfo;
    }

    @Override
    public void delUserInfoById(int id) {
        //定义sql:
        String sql = "DELETE FROM userinfo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
