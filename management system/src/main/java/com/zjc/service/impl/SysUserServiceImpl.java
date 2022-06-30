package com.zjc.service.impl;

import com.zjc.pojo.SysUser;
import com.zjc.repositories.SysUserRepository;
import com.zjc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserRepository sysUserRepository;


    @Override
    public List<SysUser> findAllUser() {
        return (List<SysUser>) sysUserRepository.findAll();
    }

    @Override
    public boolean add(SysUser sysUser) {
        SysUser save = sysUserRepository.save(sysUser);
        return save!=null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            sysUserRepository.deleteById(id);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public SysUser findById(Integer id) {
        Optional<SysUser> sysUser = sysUserRepository.findById(id);
        return sysUser.get();
    }

    @Override
    public boolean update(SysUser sysUser) {
        SysUser save = sysUserRepository.save(sysUser);
        return save!=null;
    }

    @Override
    public SysUser findByUsername(String username) {
        SysUser sysUser = sysUserRepository.findByUsername(username);
        return sysUser;

    }
}
