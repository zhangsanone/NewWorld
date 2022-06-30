package com.zjc.service;

import com.zjc.pojo.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    boolean add(Department department);

    boolean delete(Integer id);

    Department findById(Integer id);

    boolean update(Department department);
}
