package cn.tedu.egmybatis6;

import cn.tedu.egmybatis6.mapper.CustomersMapper;
import cn.tedu.egmybatis6.pojo.entity.Customers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomersTests {

    @Autowired
    private CustomersMapper customersMapper;

    @Test
    void insertCust() {
        Customers customers = new Customers();
        customers.setCustId("0004");
        customers.setCustTel("13811112222");
        customers.setCustName("Tony");
        customers.setCity("成都");
        customersMapper.insertCust(customers);
    }

    @Test
    void selectByCustId() {
        System.out.println(customersMapper.selectByCustId("0004"));
    }

    @Test
    void selectByCity() {
        System.out.println(customersMapper.selectByCity("北京"));
    }

    @Test
    void selectByList() {
        System.out.println(customersMapper.selectByCustOfList("0002"));
    }

}
