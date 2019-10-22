package com.itrum.ssm.demo.web;

import com.github.pagehelper.PageInfo;
import com.itrum.ssm.demo.domain.SysLog;
import com.itrum.ssm.demo.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService iSysLogService;

    @RequestMapping("findAll.do")
    public String findAll(BindingAwareModelMap model, @RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum,@RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize) throws Exception{
       List<SysLog> sysLogs= iSysLogService.findAll(pageNum,pageSize);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);
        model.addAttribute("pageInfo",pageInfo);
       return "syslog-list";
    }

}
