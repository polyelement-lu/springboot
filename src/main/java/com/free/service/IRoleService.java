package com.free.service;

import com.free.model.Role;

import java.util.List;

public interface IRoleService {
    /**
     * 新增一个角色
     * @param roleCode
     * @param roleName
     */
    int create(String roleCode, String roleName);

    /**
     * 根据name删除一个角色
     * @param id
     */
    int deleteById(Integer id);

    /**
     * 获取所有数据
     */
    List<Role> getAll();

}
