package com.zjc.controller;


import com.zjc.log.Log;
import com.zjc.pojo.SysPermission;
import com.zjc.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysPermission")
public class SysPermissionController {

    @Autowired
    SysPermissionService sysPermissionService;

    @RequestMapping("findAll")
    @Log(operateType = "select权限",operateExplain = "查询权限")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<SysPermission> list = sysPermissionService.findAll();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("sysPermission/show");
        return modelAndView;
    }


    @RequestMapping("add")
    @Log(operateType = "add权限",operateExplain = "添加权限")
    public String add(SysPermission sysPermission){

        boolean flag = sysPermissionService.add(sysPermission);
        return "redirect:findAll";
    }

    @RequestMapping("showAdd")
    @Log(operateType = "add页面",operateExplain = "进入add页面")
    public ModelAndView showAdd() {
        ModelAndView mv=new ModelAndView("sysPermission/add");
        return mv;
    }

    @RequestMapping("delete")
    @Log(operateType = "del权限",operateExplain = "删除权限")
    public String delete(Integer id){

        boolean flag = sysPermissionService.delete(id);
        return "redirect:findAll";
    }

    @RequestMapping("showUpdate")
    @Log(operateType = "mod页面",operateExplain = "进入mod页面")
    public ModelAndView showUpdate(Integer id){
        ModelAndView mv = new ModelAndView("sysPermission/update");
        SysPermission sysPermission = sysPermissionService.findById(id);

        mv.addObject("sysPermission",sysPermission);
        return mv;
    }

    @RequestMapping("update")
    @Log(operateType = "mod权限",operateExplain = "修改权限")
    public String update(SysPermission sysPermission){
        boolean flag = sysPermissionService.update(sysPermission);
        return "redirect:findAll";
    }
}
