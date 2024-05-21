package com.kfhstu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kfhstu.beans.Product;
import java.util.List;


public interface ProductService extends IService<Product> {

    Integer insertSelective(Product product);

    List<Product> selectByText(String selectText);

    //选择性修改
    int updateSelective(Product product);
}
