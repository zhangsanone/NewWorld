package com.zjc.controller;

import com.zjc.log.Log;
import com.zjc.pojo.Department;
import com.zjc.pojo.Employee;
import com.zjc.service.DepartmentService;
import com.zjc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping( "emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("findAll")
    @Log(operateType = "select员工",operateExplain = "查询所有员工")
    public ModelAndView findAll(Employee condition){
        ModelAndView modelAndView = new ModelAndView("emp/show");
        List<Employee> list = employeeService.findAll(condition);
        List<Department> depList = departmentService.findAll();
        modelAndView.addObject("list",list);
        modelAndView.addObject("depList",depList);
        modelAndView.addObject("c",condition);
        return modelAndView;
    }

    @RequestMapping("add")
    @Log(operateType = "add员工",operateExplain = "添加员工根据提供信息")
    public String add(Employee employee){

        boolean flag = employeeService.add(employee);
        return "redirect:findAll";
    }

    @RequestMapping("showAdd")
    @Log(operateType = "add页面",operateExplain = "进入add页面")
    public ModelAndView showAdd() {
        ModelAndView mv=new ModelAndView("emp/add");
        List<Department> depList = departmentService.findAll();
        mv.addObject("depList",depList);
        return mv;
    }

    @RequestMapping("delete")
    @Log(operateType = "delete员工",operateExplain = "删除员工根据id")
    public String delete(Integer id){

        boolean flag = employeeService.delete(id);
        return "redirect:findAll";
    }

    @RequestMapping("showUpdate")
    @Log(operateType = "mod页面",operateExplain = "进入mod页面")
    public ModelAndView showUpdate(Integer id){
        ModelAndView mv = new ModelAndView("emp/update");
        Employee employee = employeeService.findById(id);
        List<Department> depList = departmentService.findAll();
        mv.addObject("depList",depList);
        mv.addObject("emp",employee);
        return mv;
    }

    @RequestMapping("update")
    @Log(operateType = "mod员工",operateExplain = "修改员工根据修改信息")
    public String update(Employee employee){
        boolean flag = employeeService.update(employee);
        return "redirect:findAll";
    }
}
