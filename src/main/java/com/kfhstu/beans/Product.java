package com.kfhstu.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kivy0000
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "product_shop")
@SuppressWarnings("unused")
public class Product implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
    private String productId;
    private Integer Inventory;//库存
    private Integer sales;
    private String parts;//分类

    //这里是作为json格式的处理，string格式的输出仍需要单独simpleDateFormat
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date productionTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date initTime;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productId='" + productId + '\'' +
                ", Inventory=" + Inventory +
                ", sales=" + sales +
                ", parts='" + parts + '\'' +
                ", productionTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productionTime) +
                ", initTime=" +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(initTime)  +
                '}';
    }
}
