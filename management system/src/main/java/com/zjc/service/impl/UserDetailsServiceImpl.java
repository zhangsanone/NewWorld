package com.zjc.service.impl;

import com.zjc.pojo.SysPermission;
import com.zjc.pojo.SysRole;
import com.zjc.pojo.SysUser;
import com.zjc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SysUser sysUser = sysUserService.findByUsername(username);
        if (sysUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<SysRole> sysRoles = sysUser.getRoles();
        for (SysRole sysRole: sysRoles) {
            authorities.add(new SimpleGrantedAuthority(sysRole.getCode()));

            for (SysPermission sysPermission: sysRole.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(sysPermission.getCode()));
            }
        }
        return new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
    }

    public SysUser toSysUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return sysUserService.findByUsername(user.getUsername());
    }
}
