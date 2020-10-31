package com.seafwg.dao;

import com.seafwg.domain.Province;

import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: Province interface
 * TODO
 **/
public interface ProvinceDao {
    /**
     * 查询所有省份:
     */
    public List<Province> findAllProvince();
}
