package com.itrum.ssm.demo.service.impl;

import com.itrum.ssm.demo.dao.IPermission;
import com.itrum.ssm.demo.dao.IRole;
import com.itrum.ssm.demo.domain.Permission;
import com.itrum.ssm.demo.domain.Role;
import com.itrum.ssm.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRole iRole;

    @Autowired
    private IPermission iPermission;

    @Override
    public List<Role> findAll() throws Exception {
        return iRole.findAll();
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) throws Exception {
        for (String id : ids) {
            iPermission.addPermissionToRole(roleId,id);
        }

    }

    @Override
    public List<Role> findUserByIdAndAllRole(String id) throws Exception {
        return iRole.findUserByIdAndAllRole(id);
    }

    @Override
    public void save(Role role) throws Exception {
        iRole.save(role);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String roleId) throws Exception {
        return iPermission.findRoleByIdAndAllPermission(roleId);
    }

    @Override
    public Role findById(String id) throws Exception {
        Role role= iRole.findById(id);
        List<Permission> permissionByRoleId = iPermission.findPermissionByRoleId(id);
        role.setPermissions(permissionByRoleId);
        return role;
    }
}
