package cn.tedu._04mybatis;

import cn.tedu._04mybatis.mapper.UserMapper;
import cn.tedu._04mybatis.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        User user = new User();
        user.setId(126L);
        user.setUsername("zl");
        user.setPassword("123456");
        user.setNickname("zllz");
        user.setCreated(new Date());

//        userMapper.insert(user);
//        System.out.println(userMapper.delete(user));
//        userMapper.update(user);
    }

}
