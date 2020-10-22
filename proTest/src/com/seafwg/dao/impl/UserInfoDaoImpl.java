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

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserInfo> findAllUserInfo() {
        //定义sql:
        String sql = "SELECT * FROM userinfo";
//        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        List<UserInfo> userInfo = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
        return userInfo;
    }

    /**
     * 根据id删除记录
     * @param id
     */
    @Override
    public void delUserInfoById(int id) {
        //定义sql:
        String sql = "DELETE FROM userinfo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * 根据id查询这条记录
     * @param id
     * @return
     */
    @Override
    public UserInfo findUserInfoById(int id) {
        String sql = "SELECT * FROM userinfo WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), id);
    }

    /**
     * 修改数据后更新
     * @param userInfo
     */
    @Override
    public void updateUserInfo(UserInfo userInfo) {
        String sql = "UPDATE userinfo SET name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? WHERE id = ?";
        jdbcTemplate.update(sql,userInfo.getName(),userInfo.getGender(),
                userInfo.getAge(),userInfo.getAddress(),userInfo.getQq(),
                userInfo.getEmail(),userInfo.getId()
        );
    }
}
