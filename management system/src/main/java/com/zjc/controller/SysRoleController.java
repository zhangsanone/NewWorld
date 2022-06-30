package com.zjc.controller;

import com.zjc.log.Log;
import com.zjc.pojo.SysPermission;
import com.zjc.pojo.SysRole;
import com.zjc.service.SysPermissionService;
import com.zjc.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysRole")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysPermissionService sysPermissionService;

    @RequestMapping("findAll")
    @Log(operateType = "select角色",operateExplain = "查询角色")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<SysRole> list = sysRoleService.findAll();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("sysRole/show");
        return modelAndView;
    }


    @RequestMapping("add")
    @Log(operateType = "add角色",operateExplain = "添加角色")
    public String add(SysRole sysRole){

        boolean flag = sysRoleService.add(sysRole);
        return "redirect:findAll";
    }

    @RequestMapping("showAdd")
    @Log(operateType = "add页面",operateExplain = "进入添加页面")
    public ModelAndView showAdd() {
        ModelAndView mv=new ModelAndView("sysRole/add");
        List<SysPermission> permissions = sysPermissionService.findAll();
        mv.addObject("permissions", permissions);
        return mv;
    }

    @RequestMapping("delete")
    @Log(operateType = "del角色",operateExplain = "删除角色")
    public String delete(Integer id){

        boolean flag = sysRoleService.delete(id);
        return "redirect:findAll";
    }

    @RequestMapping("showUpdate")
    @Log(operateType = "mod页面",operateExplain = "进入mod页面")
    public ModelAndView showUpdate(Integer id){
        ModelAndView mv = new ModelAndView("sysRole/update");
        SysRole sysRole = sysRoleService.findById(id);
        List<SysPermission> permissions = sysPermissionService.findAll();

        mv.addObject("sysRole",sysRole);
        mv.addObject("permissions",permissions);
        return mv;
    }

    @RequestMapping("update")
    @Log(operateType = "mod角色",operateExplain = "修改角色")
    public String update(SysRole sysRole){
        boolean flag = sysRoleService.update(sysRole);
        return "redirect:findAll";
    }
}
