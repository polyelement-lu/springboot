package com.free.service.impl;

import com.free.model.City;
import com.free.model.Role;
import com.free.service.ICityService;
import com.free.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取城市逻辑：
     * 如果缓存存在，则从缓存中获取
     * 如果缓存不存在，则从db中获取，然后插入缓存
     * @param id
     * @return
     */
    @Override
    public City getCityById(Long id) {
        // 从缓存中获取城市信息
        String key = "city_"+id;
        ValueOperations<String,City> operations = redisTemplate.opsForValue();
        boolean b = redisTemplate.hasKey(key);
        if(b){
            return operations.get(key);
        }
        // 从db中获取数据
        City city = jdbcTemplate.queryForObject("select * from city where id=?", new Long[]{id}, City.class);
        // 插入缓存
        operations.set(key,city,10, TimeUnit.SECONDS);
        return city;
    }

    /**
     * 数据更新逻辑
     * 如果缓存存在，删除缓存
     * 如果缓存不存在，不操作
     * @param city
     * @return
     */
    @Override
    public void update(City city) {
        Long id = city.getId();
        String key = "city_"+id;
        boolean b = redisTemplate.hasKey(key);
        // 如果缓存存在则删除缓存
        if(b){
            redisTemplate.delete(key);
        }
    }
    @Cacheable(value = "all")
    @Override
    public List<City> getAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from city");
        return City.toObject(list);
    }
}
