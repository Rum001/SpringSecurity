package com.itrum.ssm.demo.service;

import com.itrum.ssm.demo.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    void deletePermission(String id) throws Exception;

    Permission findById(String id) throws Exception;
}
