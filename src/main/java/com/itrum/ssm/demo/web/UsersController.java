package com.itrum.ssm.demo.web;


import com.github.pagehelper.PageInfo;
import com.itrum.ssm.demo.domain.Role;
import com.itrum.ssm.demo.domain.UserInfo;
import com.itrum.ssm.demo.service.IRoleService;
import com.itrum.ssm.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("findAll.do")
    public String findAll(BindingAwareModelMap model, @RequestParam(name = "pageNum",required = false)Integer pageNum, @RequestParam(name="pageSize",required = false,defaultValue = "5")Integer pageSize) throws Exception {
        List<UserInfo> userInfoList= iUserService.findAll(pageNum,pageSize);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        model.addAttribute("pageInfo",pageInfo);
        return "user-list";
    }

    @RequestMapping("save.do")
    public String save(UserInfo userInfo) throws Exception {
        iUserService.save(userInfo);
        return "redirect:findAll.do?pageNum=1&pageSize=5";
    }

    @RequestMapping("findById.do")
    public String findById(@RequestParam(name = "id",required = false)String id,BindingAwareModelMap model){
       UserInfo userInfo= iUserService.findById(id);
       model.addAttribute("user",userInfo);
       return "user-show";
    }
    @RequestMapping("findUserByIdAndAllRole.do")
    public String findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String id,BindingAwareModelMap model)throws Exception{
       List<Role> roleList= iRoleService.findUserByIdAndAllRole(id);
       model.addAttribute("roleList",roleList);
       model.addAttribute("user",id);
       return "user-role-add";
    }

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,@RequestParam(name = "ids",required = true)String []ids) throws Exception{
        iUserService.addRoleToUser(userId,ids);
        return "redirect:findAll.do?pageNum=1&pageSize=5";
    }

}
