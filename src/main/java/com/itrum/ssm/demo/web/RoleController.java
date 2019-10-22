package com.itrum.ssm.demo.web;

import com.itrum.ssm.demo.domain.Permission;
import com.itrum.ssm.demo.domain.Role;
import com.itrum.ssm.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("findAll.do")
    public String findAll(BindingAwareModelMap model) throws Exception {
       List<Role> roleList= iRoleService.findAll();
       model.addAttribute("roleList",roleList);
       return "role-list";
    }
    @RequestMapping("save.do")
    public String save(Role Role) throws Exception {
        iRoleService.save(Role);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public String findById(@RequestParam(name = "id")String id,BindingAwareModelMap model) throws Exception{
        Role role = iRoleService.findById(id);
        model.addAttribute("role",role);
        return "role-show";
    }

    @RequestMapping("findRoleByIdAndAllPermission.do")
    public String findRoleByIdAndAllPermission(@RequestParam(name = "roleId",required = true)String roleId,BindingAwareModelMap model) throws Exception{
       List<Permission>permissionList= iRoleService.findRoleByIdAndAllPermission(roleId);
        model.addAttribute("role",roleId);
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";
    }
    @RequestMapping("addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = false)String roleId,@RequestParam(name = "ids",required = false)String []ids) throws Exception{
       iRoleService.addPermissionToRole(roleId,ids);
       return "redirect:findAll.do";
    }

}
