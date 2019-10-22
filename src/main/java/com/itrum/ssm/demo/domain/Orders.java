package com.itrum.ssm.demo.domain;

import com.itrum.ssm.demo.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 订单表
 */
@Data
public class Orders {

    private String id;
    private String orderNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date orderTime;

    private String orderTimeStr;

    private int orderStatus;

    private String orderStatusStr;
    private int peopleCount;
    private Product product;

    private List<Traveller> travellers;

    private Member member;
    private Integer payType;

    private String payTypeStr;

    private String orderDesc;

    public String getOrderTimeStr() {
        if (orderTime!=null)
            orderTimeStr= DateUtils.dateToString(orderTime,"yyyy-MM-dd hh:mm");
        return orderTimeStr;
    }

    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2 其它)
        if (payType==0){
            payTypeStr="支付宝";
        }else if (payType==1){
            payTypeStr="微信";
        }else {
            payTypeStr="其它";
        }
        return payTypeStr;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if (orderStatus==0){
            orderStatusStr="未支付";
        }else {
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }
}
