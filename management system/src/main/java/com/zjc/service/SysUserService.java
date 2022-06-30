package com.zjc.service;

import com.zjc.pojo.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> findAllUser();

    boolean add(SysUser sysUser);

    boolean delete(Integer id);

    SysUser findById(Integer id);

    boolean update(SysUser sysUser);

    SysUser findByUsername(String username);
}
