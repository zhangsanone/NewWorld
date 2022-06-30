package com.zjc.service.impl;

import com.zjc.pojo.SysRole;
import com.zjc.repositories.SysRoleRepository;
import com.zjc.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleRepository sysRoleRepository;

    @Override
    public List<SysRole> findAll() {
        return (List<SysRole>) sysRoleRepository.findAll();
    }

    @Override
    public boolean add(SysRole sysRole) {
        SysRole save = sysRoleRepository.save(sysRole);
        return save!=null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            sysRoleRepository.deleteById(id);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public SysRole findById(Integer id) {
        Optional<SysRole> sysRole = sysRoleRepository.findById(id);
        return sysRole.get();

    }

    @Override
    public boolean update(SysRole sysRole) {
        SysRole save = sysRoleRepository.save(sysRole);
        return save!=null;
    }
}
