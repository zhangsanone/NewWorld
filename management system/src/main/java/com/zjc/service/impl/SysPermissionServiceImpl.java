package com.zjc.service.impl;

import com.zjc.pojo.SysPermission;
import com.zjc.repositories.SysPermissionRepository;
import com.zjc.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    SysPermissionRepository sysPermissionRepository;

    @Override
    public List<SysPermission> findAll() {
        return (List<SysPermission>) sysPermissionRepository.findAll();
    }

    @Override
    public boolean add(SysPermission sysPermission) {
        SysPermission save = sysPermissionRepository.save(sysPermission);
        return save!=null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            sysPermissionRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public SysPermission findById(Integer id) {
        Optional<SysPermission> sysPermission = sysPermissionRepository.findById(id);
        return sysPermission.get();

    }

    @Override
    public boolean update(SysPermission sysPermission) {
        SysPermission save = sysPermissionRepository.save(sysPermission);
        return save!=null;
    }
}
