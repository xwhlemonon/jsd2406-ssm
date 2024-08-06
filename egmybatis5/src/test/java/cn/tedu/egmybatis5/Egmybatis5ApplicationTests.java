package cn.tedu.egmybatis5;

import cn.tedu.egmybatis5.mapper.CustomersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Egmybatis5ApplicationTests {

    @Autowired
    private CustomersMapper customersMapper;

    @Test
    void contextLoads() {
        System.out.println(customersMapper.select("0001"));
    }

}
