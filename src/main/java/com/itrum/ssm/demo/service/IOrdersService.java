package com.itrum.ssm.demo.service;

import com.itrum.ssm.demo.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll(int pageNum,int pageSize) throws  Exception;

    Orders findById(int id) throws Exception;
}
