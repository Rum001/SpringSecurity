package com.itrum.ssm.demo.domain;

import com.itrum.ssm.demo.utils.DateUtils;
import lombok.Data;

import java.util.Date;

@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public String getVisitTimeStr() {
        if (visitTime!=null)
            visitTimeStr=DateUtils.dateToString(visitTime,"yyyy-MM-dd hh:mm");
        return visitTimeStr;
    }
}