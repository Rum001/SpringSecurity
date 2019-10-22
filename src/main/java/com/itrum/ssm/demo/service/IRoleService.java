package com.itrum.ssm.demo.service;

import com.itrum.ssm.demo.domain.Permission;
import com.itrum.ssm.demo.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    List<Role> findUserByIdAndAllRole(String id) throws Exception;

    List<Permission> findRoleByIdAndAllPermission(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] ids) throws Exception;
}
