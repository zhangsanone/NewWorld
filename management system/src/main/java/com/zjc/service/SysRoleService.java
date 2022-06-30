package com.zjc.service;

import com.zjc.pojo.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> findAll();

    boolean add(SysRole sysRole);

    boolean delete(Integer id);

    SysRole findById(Integer id);

    boolean update(SysRole sysRole);
}
