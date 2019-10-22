package com.itrum.ssm.demo.domain;


import com.itrum.ssm.demo.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Product {
    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date departureTime; // 出发时间
    private String departureTimeStr;
    private Double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;
    public String getDepartureTimeStr(){
        if (departureTime!=null)
            departureTimeStr= DateUtils.dateToString(departureTime,"yyyy-MM-dd hh:mm:ss");
        return departureTimeStr;
    }
    public String getProductStatusStr(){
        if (productStatus==0)
            productStatusStr="关闭";
        else
            productStatusStr="开启";
        return productStatusStr;
    }
}
