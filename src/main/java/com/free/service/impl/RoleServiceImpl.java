package com.free.service.impl;

import com.free.model.Role;
import com.free.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int create(String roleCode, String roleName) {
        return jdbcTemplate.update("INSERT INTO role (role_code,role_name) VALUES (?,?)", roleCode, roleName);
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("DELETE from role where id=?", id);
    }

    @Override
    public List<Role> getAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * from role");
        return Role.toObject(list);
    }
}
