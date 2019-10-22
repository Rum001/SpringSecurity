package com.itrum.ssm.demo.dao;

import com.itrum.ssm.demo.domain.SysLog;

import java.util.List;

public interface ISysLog {
    void save(SysLog sysLog);

    List<SysLog> findAll();
}
