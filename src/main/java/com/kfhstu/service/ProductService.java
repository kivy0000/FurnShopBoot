package com.kfhstu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kfhstu.beans.Product;

/**
 *
 */
public interface ProductService extends IService<Product> {

    Integer insertSelective(Product product);



}
