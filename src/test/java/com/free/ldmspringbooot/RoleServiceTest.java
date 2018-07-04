package com.free.ldmspringbooot;

import com.free.model.Role;
import com.free.service.IRoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {
    @Autowired
    private IRoleService roleService;

    @Before
    public void setUp() {
        // 准备，清空user表
    }

    @Test
    public void test() throws Exception {
        for (int i = 0; i <5 ; i++) {
            roleService.create("qwe"+i,"测试"+i*10);
        }
//        List<Role> all = roleService.getAll();
//        System.err.println("数据："+all.size());
//        System.err.println("数据："+all.toString());

    }
    @Test
    public void test01() throws Exception {
        List<Role> all = roleService.getAll();
        for(Role role:all){
            System.out.println("xx:"+role.getRoleCode()+role.getRoleName());
        }
        System.err.println("数据："+all.size());
    }
    @Test
    public void test02() throws Exception {
        roleService.deleteById(11);
    }
}
