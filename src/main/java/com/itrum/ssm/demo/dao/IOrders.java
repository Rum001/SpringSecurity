package com.itrum.ssm.demo.dao;

import com.itrum.ssm.demo.domain.Orders;

import java.util.List;

public interface IOrders {

    List<Orders> findAll() throws Exception;

    Orders findById(int id) throws Exception;
}
