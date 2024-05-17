package com.kfhstu.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kfhstu.beans.Product;

/**
 *
 */
//@Mapper,使用mapperscan代替
public interface ProductMapper extends BaseMapper<Product> {

    //可以使用BaseMapper的方法，也可以自定义方法

    Integer insertSelective(Product product);

}
