package cn.tedu.egmybatis6.pojo.vo;

import cn.tedu.egmybatis6.pojo.entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class CustomersVO3 {
    private String custId;
    private String custName;
    private List<Orders> ordersList;
}
