package com.itrum.ssm.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if (status==0)
            statusStr="未开启";
        else
        statusStr="已开启";
        return statusStr;
    }
}
