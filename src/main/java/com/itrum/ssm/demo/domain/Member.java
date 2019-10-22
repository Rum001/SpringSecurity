package com.itrum.ssm.demo.domain;

import lombok.Data;

/**
 * 会员表
 */
@Data
public class Member {

    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}