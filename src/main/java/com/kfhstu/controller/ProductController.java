package com.kfhstu.controller;

import com.kfhstu.beans.Product;
import com.kfhstu.service.ProductService;
import com.kfhstu.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kivy0000
 * @version 1.0
 */
@RestController
@SuppressWarnings("rawtypes")//抑制原始使用警告
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 测试
     */
    @RequestMapping("/")
    public Result<List<Product>> index() {
        return Result.success(productService.list());
    }

    /**
     * 查询所有设备
     */
    @GetMapping("getAll")
    public Result getAllProduct() {
        List<Product> pList = productService.list();
        return (pList == null || pList.size() <= 0) ? Result.warning() : Result.success(productService.list());

    }

    /**
     * 选择性添加设备，post
     */
    @PostMapping("/addProduct")
    public Result addProduct(@RequestBody Product product) {
        try {
//            查询等待一秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer id = productService.insertSelective(product);
        return (id <= 0) ? Result.warning() : Result.success();
    }

    /**
     * 根据ID删除项目
     */
    @DeleteMapping("/deleteProduct")
    public Result deleteProduct(@RequestBody Product product) {
        return productService.removeById(product.getId()) ? Result.success() : Result.warning();
    }

    /**
     * 根据批量删除项目
     */
    @DeleteMapping("/deleteMoreProduct")
    public Result deleteMoreProduct(@RequestBody List<Integer> ids) {
        return productService.removeByIds(ids) ? Result.success() : Result.warning();
    }

    /**
     * 根据关键字查找项目
     *
     * @param keyWord 关键字
     */
    @GetMapping("/selectByText/{keyWord}")
    public Result selectByText(@PathVariable String keyWord) {
        try {
//            查询等待一秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Product> products = productService.selectByText(keyWord);
        return products.size() > 0 ? Result.success(products) : Result.warning();
    }


    @PutMapping("/editProduct")
    public Result editProduct(@RequestBody Product product) {
        productService.updateSelective(product);
        return Result.success();
    }
}
