package com.itrum.ssm.demo.service;

import com.itrum.ssm.demo.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(Integer pageNum,Integer pageSize) throws Exception;

    void save(Product product) throws  Exception;
}
