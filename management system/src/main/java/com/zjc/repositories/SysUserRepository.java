package com.zjc.repositories;

import com.zjc.pojo.SysUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserRepository extends PagingAndSortingRepository<SysUser,Integer> {

    SysUser findByUsername(String username);
}
