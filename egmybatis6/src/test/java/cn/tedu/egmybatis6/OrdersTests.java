package cn.tedu.egmybatis6;

import cn.tedu.egmybatis6.mapper.OrdersMapper;
import cn.tedu.egmybatis6.pojo.entity.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class OrdersTests {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    void insertCust() {
        Orders orders = new Orders();
        orders.setOrderId("202301020004");
        orders.setCustId("0004");
        orders.setOrderDate(new Date());
        orders.setStatus(3);
        orders.setProductsNum(4);
        orders.setAmt(800.88);
        ordersMapper.insertOrders(orders);
    }

    @Test
    void updateCust() {
        Orders orders = new Orders();
        orders.setOrderId("202301020004");
        orders.setStatus(1);
        orders.setProductsNum(0);
        orders.setAmt(80.88);
        ordersMapper.updateOrders(orders);
    }

}
