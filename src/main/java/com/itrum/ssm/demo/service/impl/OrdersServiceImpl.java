package com.itrum.ssm.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.itrum.ssm.demo.dao.IOrders;
import com.itrum.ssm.demo.domain.Orders;
import com.itrum.ssm.demo.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrders iOrders;

    @Override
    public List<Orders> findAll(int pageNum,int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return iOrders.findAll();
    }

    @Override
    public Orders findById(int id) throws Exception {
        return iOrders.findById(id);
    }
}
