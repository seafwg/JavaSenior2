package com.seafwg.dao;

import com.seafwg.domain.User;
import com.seafwg.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: UserDao
 * TODO
 **/
public class UserDao {
    //声明JDBCUtils对象：
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    //封装一个查询的方法：
    public User login(User loginUser) {
        try {
            String sql = "SELECT * FROM user where name=? && password=?";
            User user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getName(),
                    loginUser.getPassword()
            );

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            //记录日志
            return null;
        }
    }
}
