package com.itrum.ssm.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.itrum.ssm.demo.dao.ISysLog;
import com.itrum.ssm.demo.domain.SysLog;
import com.itrum.ssm.demo.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLog iSysLog;

    @Override
    public List<SysLog> findAll(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return  iSysLog.findAll();
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        iSysLog.save(sysLog);
    }
}
