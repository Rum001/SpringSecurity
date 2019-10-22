package com.itrum.ssm.demo.service;

import com.itrum.ssm.demo.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer pageNum,Integer pageSize) throws Exception;
}
