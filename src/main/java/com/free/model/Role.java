package com.free.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Role {
    private Integer id;
    private String roleCode;
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static Role toObject(Map<String, Object> map) {
        Role role = new Role();
        role.setId((Integer) map.get("id"));
        role.setRoleCode((String) map.get("role_code"));
        role.setRoleName((String) map.get("role_name"));
        return role;
    }

    public static List<Role> toObject(List<Map<String, Object>> lists){
        List<Role> list = new ArrayList<>();
        for (Map<String, Object> map : lists) {
            Role roleInfo =  Role.toObject(map);
            if (roleInfo != null) {
                list.add(roleInfo);
            }
        }
        return list;
    }

}
