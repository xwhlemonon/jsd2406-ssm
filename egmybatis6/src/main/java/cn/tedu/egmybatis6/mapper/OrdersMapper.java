package cn.tedu.egmybatis6.mapper;

import cn.tedu.egmybatis6.pojo.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {
    void insertOrders(Orders orders);

    void updateOrders(Orders orders);
}
