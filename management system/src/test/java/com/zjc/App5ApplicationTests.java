package com.zjc;

import com.zjc.pojo.SysUser;
import com.zjc.repositories.SysUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class App5ApplicationTests {

    @Autowired
    SysUserRepository sysUserRepository;

    @Test
    @Transactional
    public void test(){


        SysUser admin = sysUserRepository.findByUsername("admin");
        System.out.println(admin);
    }

}
