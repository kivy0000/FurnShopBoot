package com.kfhstu.controller;

import com.kfhstu.beans.Product;
import com.kfhstu.mapper.ProductMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kivy0000
 * @version 1.0
 */
@RestController
public class ProductController {

    @Resource
    private ProductMapper productMapper;

    @RequestMapping("/")
    public List<Product> index() {
        List<Product> products = productMapper.selectList(null);
        for (Product product : products) {
            System.out.println(product + "\n");
        }
        return productMapper.selectList(null);
    }
}
