package cn.tedu._5weibo;

import cn.tedu._5weibo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTests {
    @Autowired
    public UserMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(mapper.selectNumById(100L));
    }

}
