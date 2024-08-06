package cn.tedu.egmybatis5.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private String orderId;
    private String custId;
    private Date orderDate;
    private Integer status;
    private Integer productsNum;
    private Double amt;
}
