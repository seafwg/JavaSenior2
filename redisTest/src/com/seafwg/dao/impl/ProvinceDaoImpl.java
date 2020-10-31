package com.seafwg.dao.impl;

import com.seafwg.dao.ProvinceDao;
import com.seafwg.domain.Province;
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
public class ProvinceDaoImpl implements ProvinceDao {
    //①声明JdbcTemplate成员变量
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询数据库所有的城市信息
     * @return
     */
    @Override
    public List<Province> findAllProvince() {
        //①定义sql
        String sql = "SELECT * FROM province";
        List<Province> provinceList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return provinceList;
    }
}
