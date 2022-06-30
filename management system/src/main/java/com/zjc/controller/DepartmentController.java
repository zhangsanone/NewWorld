package com.zjc.controller;

import com.zjc.log.Log;
import com.zjc.pojo.Department;
import com.zjc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("dep")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("findAll")
    @Log(operateType = "select部门",operateExplain = "查询部门")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Department> list = departmentService.findAll();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("dep/show");
        return modelAndView;
    }

    @RequestMapping("add")
    @Log(operateType = "add部门",operateExplain = "添加部门根据需求")
    public String add(Department department){

        boolean flag = departmentService.add(department);
        return "redirect:findAll";
    }

    @RequestMapping("showAdd")
    @Log(operateType = "add页面",operateExplain = "进入add页面")
    public ModelAndView showAdd() {
        ModelAndView mv=new ModelAndView("dep/add");
        return mv;
    }

    @RequestMapping("delete")
    @Log(operateType = "delete部门",operateExplain = "删除部门根据id")
    public String delete(Integer id){

        boolean flag = departmentService.delete(id);
        return "redirect:findAll";
    }

    @RequestMapping("showUpdate")
    @Log(operateType = "mod页面",operateExplain = "进入修改页面")
    public ModelAndView showUpdate(Integer id){
        ModelAndView mv = new ModelAndView("dep/update");
        Department department = departmentService.findById(id);

        mv.addObject("dep",department);
        return mv;
    }

    @RequestMapping("update")
    @Log(operateType = "mod部门",operateExplain = "修改部门根据更改内容")
    public String update(Department department){
        boolean flag = departmentService.update(department);
        return "redirect:findAll";
    }
}
