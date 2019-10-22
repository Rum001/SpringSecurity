package com.itrum.ssm.demo.web;

import com.itrum.ssm.demo.domain.Permission;
import com.itrum.ssm.demo.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService iPermissionService;

    @RequestMapping("findAll.do")
    public String findAll(BindingAwareModelMap model) throws Exception{
       List<Permission> permissionList= iPermissionService.findAll();
        model.addAttribute("permissionList",permissionList);
        return "permission-list";
    }

    @RequestMapping("save.do")
    public String save(Permission permission) throws Exception{
        iPermissionService.save(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("deletePermission.do")
    public String deletePermission(@RequestParam(name = "id",required = true) String id) throws Exception{
        iPermissionService.deletePermission(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public String findById(@RequestParam(name = "id")String id, BindingAwareModelMap model)throws Exception{
        Permission permission= iPermissionService.findById(id);
        model.addAttribute("permission",permission);
        return "permission-show";
    }

}
