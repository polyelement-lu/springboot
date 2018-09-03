package com.free.service;

import com.free.model.City;
import com.free.model.Role;

import java.util.List;

public interface ICityService {
    /**
     * 根据城市id获取数据
     */
    City getCityById(Long id);

    /**
     * 修改
     * @param city
     * @return
     */
    void update(City city);
    /**
     * 获取所有数据
     */
    List<City> getAll();

}
