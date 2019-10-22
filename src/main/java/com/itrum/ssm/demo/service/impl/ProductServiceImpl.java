package com.itrum.ssm.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.itrum.ssm.demo.dao.IProduct;
import com.itrum.ssm.demo.domain.Product;
import com.itrum.ssm.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProduct iProduct;


    @Override
    public void save(Product product)throws Exception {
        iProduct.save(product);
    }

    public List<Product> findAll(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return iProduct.findAll();
    }
}
