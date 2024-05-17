package com.kfhstu.controller;

import com.kfhstu.beans.Product;
import com.kfhstu.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kivy0000
 * @version 1.0
 */
@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    //测试项目
    @RequestMapping("/")
    public List<Product> index() {
        return productService.list();
    }

    //查询所有设备
    @GetMapping("getAll")
    public List<Product> getAllProduct() {
        return productService.list();
    }

    //添加设备，post
    @PostMapping("/addProduct")
    public Integer addProduct(@RequestBody Product product) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productService.insertSelective(product);
    }
}
