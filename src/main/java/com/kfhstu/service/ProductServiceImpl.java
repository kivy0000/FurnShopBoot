package com.kfhstu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfhstu.beans.Product;
import com.kfhstu.mapper.ProductMapper;
import org.springframework.stereotype.Service;


/**
 * @author kivy0000
 * @version 1.0
 */
@Service
public class ProductServiceImpl
        extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

}
