package com.zjc.service;

import com.zjc.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll(Employee condition);

    boolean add(Employee employee);

    boolean delete(Integer id);

    Employee findById(Integer id);

    boolean update(Employee employee);
}
