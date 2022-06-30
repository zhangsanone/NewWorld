package com.zjc.service.impl;

import com.zjc.pojo.Employee;
import com.zjc.repositories.EmployeeRepository;
import com.zjc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll(Employee condition) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); //所有模糊查询
        // 通过example进行构建查询条件
        Example<Employee> example = Example.of(condition, matcher);

        return (List<Employee>) employeeRepository.findAll(example);

    }

    @Override
    public boolean add(Employee employee) {
        Employee save = employeeRepository.save(employee);
        return save!=null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.get();
    }

    @Override
    public boolean update(Employee employee) {
        Employee save = employeeRepository.save(employee);
        return save!=null;
    }
}
