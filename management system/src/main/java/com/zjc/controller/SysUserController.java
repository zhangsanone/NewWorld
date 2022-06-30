package com.zjc.controller;

import com.zjc.log.Log;
import com.zjc.pojo.SysRole;
import com.zjc.pojo.SysUser;
import com.zjc.service.SysRoleService;
import com.zjc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService sysRoleService;

    @RequestMapping("findAll")
    @Log(operateType = "select用户",operateExplain = "查询用户")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<SysUser> list = sysUserService.findAllUser();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("sysUser/show");
        return modelAndView;
    }

    @RequestMapping("add")
    @Log(operateType = "add用户",operateExplain = "添加用户")
    public String add(SysUser sysUser){

        boolean flag = sysUserService.add(sysUser);
        return "redirect:findAll";
    }

    @RequestMapping("showAdd")
    @Log(operateType = "add页面",operateExplain = "进入add页面")
    public ModelAndView showAdd() {
        ModelAndView mv=new ModelAndView("sysUser/add");
        List<SysRole> roles = sysRoleService.findAll();
        mv.addObject("roles", roles);
        return mv;
    }

    @RequestMapping("delete")
    @Log(operateType = "del用户",operateExplain = "删除用户")
    public String delete(Integer id){

        boolean flag = sysUserService.delete(id);
        return "redirect:findAll";
    }

    @RequestMapping("showUpdate")
    @Log(operateType = "mod页面",operateExplain = "进入修改页面")
    public ModelAndView showUpdate(Integer id){
        ModelAndView mv = new ModelAndView("sysUser/update");
        SysUser sysUser = sysUserService.findById(id);
        List<SysRole> roles = sysRoleService.findAll();

        mv.addObject("sysUser",sysUser);
        mv.addObject("roles",roles);
        return mv;
    }

    @RequestMapping("update")
    @Log(operateType = "mod用户",operateExplain = "修改用户")
    public String update(SysUser sysUser){
        boolean flag = sysUserService.update(sysUser);
        return "redirect:findAll";
    }
}
