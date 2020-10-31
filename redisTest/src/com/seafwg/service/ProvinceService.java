package com.seafwg.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seafwg.domain.Province;

import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public interface ProvinceService {
    /**
     * 查询所有城市
     */
    public List<Province> findAllProvince();

    /**
     * 从redis查询json
     * @return json String
     */
    public String findAllJson() throws JsonProcessingException;

}
