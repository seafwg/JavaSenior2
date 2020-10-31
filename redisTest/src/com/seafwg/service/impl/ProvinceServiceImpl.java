package com.seafwg.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seafwg.dao.impl.ProvinceDaoImpl;
import com.seafwg.domain.Province;
import com.seafwg.jedis.utils.JedisUtils;
import com.seafwg.service.ProvinceService;
import redis.clients.jedis.Jedis;

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

    @Override
    public String findAllJson() {
        //①获取Jedis对象，获取链接
        Jedis jedis = JedisUtils.getJedis();
        String province = jedis.get("province");
        if(province == null || province.length() == 0) {
            //jedis不存在
            //①调用Dao层查询数据库
            List<Province> allProvince = pdi.findAllProvince();
            System.out.println("allProvince:"+allProvince);
            //②序列化数据为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province = mapper.writeValueAsString(allProvince);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
//            System.out.println(province);
            //③将数据存入redis中
            jedis.set("province", province);
            //失误，保存成没有序列化的数据，结果保存在redis中一直没有去更新，关闭redis服务数据还有，手动删除数据。
            jedis.close();
        }else{
            System.out.println("redis 中有数据正在从redis中查询数据...");
        }
//        System.out.println(province);
        return province;
    }
}
