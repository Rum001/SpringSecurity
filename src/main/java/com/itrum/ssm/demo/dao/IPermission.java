package com.itrum.ssm.demo.dao;

import com.itrum.ssm.demo.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPermission {

    List<Permission> findPermissionByRoleId(String roleId);

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    void deletePermission(String id) throws Exception;

    void deletePermission_role(String id) throws Exception;

    Permission findById(String id) throws Exception;

    List<Permission> findRoleByIdAndAllPermission(String roleId) throws Exception;

    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String id) throws Exception;
}
