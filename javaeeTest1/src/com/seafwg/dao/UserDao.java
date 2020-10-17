package com.seafwg.dao;

import com.seafwg.domain.User;
import com.seafwg.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: UserDao:用户数据库操作
 * TODO
 **/
public class UserDao {
    //声明JDBCTemplate对象
    //JdbcTemplate JdbcTemplate(DataSource ds);
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * login 登录方法：
     * @return
     */
    public User login(User loginUser) {
        try {
            // 定义查询sql
            String sql = "SELECT * FROM userlogin WHERE username=? and password=?";
            // 调用query查询
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword()
            );
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();

            return null;
        }
    }
}
