package cn.tedu.egmybatis4.mybatis.entity;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String title;
    private Double price;
    private Integer stock;
}
