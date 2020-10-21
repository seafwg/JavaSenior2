package com.seafwg.dao.impl;

import com.seafwg.dao.UserDao;
import com.seafwg.domain.User;
import com.seafwg.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class UserDaoImpl implements UserDao {
    //声明JdbcTemplate对象
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserByUserNameAndPassword(User loginUser) {
        //定义sql;
        try {
            String sql = "SELECT * FROM user WHERE name=? and password=?";
            User user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getName(),
                    loginUser.getPassword()
            );
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            //异常处理：
            return null;
        }
    }
}
