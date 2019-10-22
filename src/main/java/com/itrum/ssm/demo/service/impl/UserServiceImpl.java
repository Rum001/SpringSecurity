package com.itrum.ssm.demo.service.impl;


import com.github.pagehelper.PageHelper;
import com.itrum.ssm.demo.dao.IPermission;
import com.itrum.ssm.demo.dao.IRole;
import com.itrum.ssm.demo.dao.IUsers;
import com.itrum.ssm.demo.domain.Permission;
import com.itrum.ssm.demo.domain.Role;
import com.itrum.ssm.demo.domain.UserInfo;
import com.itrum.ssm.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUsers iUsers;

    @Autowired
    private IRole iRole;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IPermission iPermission;

    @Override
    public void addRoleToUser(String userId, String[] ids) throws Exception {
        for (String id : ids) {
            iUsers.addRoleToUser(userId,id);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserInfo userInfo = null;
        try {
            userInfo = iUsers.findUserById(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Role> roleByUserId = iRole.findRoleByUserId(userInfo.getId());
        userInfo.setRoles(roleByUserId);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,loadAuthority(userInfo.getRoles()));
        return user;
    }

    private List<GrantedAuthority>loadAuthority(List<Role> roles){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public List<UserInfo> findAll(int pageNum,int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
       return iUsers.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUsers.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo userInfo= iUsers.findById(id);
        List<Role> roleByUserId = iRole.findRoleByUserId(userInfo.getId());
        for (Role role : roleByUserId) {
            List<Permission> permissions = iPermission.findPermissionByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        userInfo.setRoles(roleByUserId);
        return userInfo;
    }
}
