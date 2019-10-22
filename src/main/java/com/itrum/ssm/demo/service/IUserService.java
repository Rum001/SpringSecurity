package com.itrum.ssm.demo.service;


import com.itrum.ssm.demo.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll(int pageNum,int pageSize) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id);

    void addRoleToUser(String userId, String[] ids) throws Exception;
}
