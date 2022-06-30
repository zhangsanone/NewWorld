package com.zjc.service.impl;

import com.zjc.pojo.Department;
import com.zjc.repositories.DepartmentRepository;
import com.zjc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public boolean add(Department department) {
        Department save = departmentRepository.save(department);
        return save!=null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            departmentRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Department findById(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.get();
    }

    @Override
    public boolean update(Department department) {
        Department save = departmentRepository.save(department);
        return save!= null;
    }
}
