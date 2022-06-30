package com.zjc.service;

import com.zjc.pojo.SysPermission;

import java.util.List;

public interface SysPermissionService {
    List<SysPermission> findAll();

    boolean add(SysPermission sysPermission);

    boolean delete(Integer id);

    SysPermission findById(Integer id);

    boolean update(SysPermission sysPermission);
}
