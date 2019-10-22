package com.itrum.ssm.demo.service.impl;

import com.itrum.ssm.demo.dao.IPermission;
import com.itrum.ssm.demo.domain.Permission;
import com.itrum.ssm.demo.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermission iPermission;

    @Override
    public List<Permission> findAll() throws Exception {
      return iPermission.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        iPermission.save(permission);
    }

    @Override
    public void deletePermission(String id) throws Exception {
        iPermission.deletePermission(id);
        iPermission.deletePermission_role(id);
    }

    @Override
    public Permission findById(String id) throws Exception {
       return iPermission.findById(id);
    }
}
