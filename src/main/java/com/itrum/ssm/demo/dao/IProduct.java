package com.itrum.ssm.demo.dao;

import com.itrum.ssm.demo.domain.Product;

import java.util.List;

public interface IProduct {

    List<Product> findAll() throws Exception;

    //添加商品
    void save(Product product) throws  Exception;

}
