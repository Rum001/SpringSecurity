package com.itrum.ssm.demo.dao;

import com.itrum.ssm.demo.domain.Role;

import java.util.List;

public interface IRole {

    List<Role>findRoleByUserId(String id);

    List<Role> findAll();

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    List<Role> findUserByIdAndAllRole(String id) throws Exception;
}
