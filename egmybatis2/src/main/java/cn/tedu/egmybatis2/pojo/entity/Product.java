package cn.tedu.egmybatis2.pojo.entity;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String title;
    private Double price;
    private Integer stock;
}
