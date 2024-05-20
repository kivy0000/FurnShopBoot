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

    /**
     * 测试
     *
     */
    @RequestMapping("/")
    public List<Product> index() {
        return productService.list();
    }

    /**
     * 查询所有设备
     */
    @GetMapping("getAll")
    public List<Product> getAllProduct() {
        return productService.list();
    }

    /**
     * 选择性添加设备，post
     */
    @PostMapping("/addProduct")
    public Integer addProduct(@RequestBody Product product) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productService.insertSelective(product);
    }

    /**
     * 根据ID删除项目
     */
    @DeleteMapping("/deleteProduct")
    public Integer deleteProduct(@RequestBody Product product){
        return productService.removeById(product.getId())?1:-1;
//        return productService.deleteById(product);
    }
    /**
     * 根据批量删除项目
     */
    @DeleteMapping("/deleteMoreProduct")
    public Integer deleteMoreProduct(@RequestBody List<Integer> ids){
        boolean b = productService.removeByIds(ids);
        return b?1:-1;
    }
}
