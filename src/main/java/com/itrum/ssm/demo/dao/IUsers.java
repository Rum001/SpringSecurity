package com.itrum.ssm.demo.dao;

import com.itrum.ssm.demo.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUsers {

    UserInfo findUserById(String username) throws Exception;

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id);

    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
