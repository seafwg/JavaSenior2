package com.seafwg.service.impl;

import com.seafwg.dao.impl.ProvinceDaoImpl;
import com.seafwg.domain.Province;
import com.seafwg.service.ProvinceService;

import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class ProvinceServiceImpl implements ProvinceService {
    //创建dao的对象
    private ProvinceDaoImpl pdi = new ProvinceDaoImpl();

    /**
     * 调用dao层的查询城市的方法：
     * @return
     */
    @Override
    public List<Province> findAllProvince() {
        return pdi.findAllProvince();
    }
}
