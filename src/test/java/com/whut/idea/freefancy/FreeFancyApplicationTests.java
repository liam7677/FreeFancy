package com.whut.idea.freefancy;


import com.whut.idea.freefancy.entity.Role;
import com.whut.idea.freefancy.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FreeFancyApplicationTests {

    @Autowired
    RoleService roleService;

    @Test
    void contextLoads() {
    }

    @Test
    void dbTest(){
        List<Role> list = roleService.list();
        System.out.println(list);
    }

}
