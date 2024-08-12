package cn.tedu._5mvcboot02;

import cn.tedu._5mvcboot02.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserMapperTests {

    @Autowired
    public UserMapper userMapper;

//    @Test
//    void reg() {
//        InsertUserVO insertUserVO = new InsertUserVO();
//        insertUserVO.setUsername("xwh");
//        insertUserVO.setPassword("123");
//        insertUserVO.setNickname("xiaoxiong");
//        insertUserVO.setCreated(new Date());
//
//        userMapper.reg(insertUserVO);
//    }
//
//    @Test
//    void deleteUser() {
//        userMapper.deleteUser(1);
//    }
//
//    @Test
//    void updateUser() {
//        UpdateUserVO updateUserVO = new UpdateUserVO();
//        updateUserVO.setId(2);
//        updateUserVO.setPassword("456");
//
//        userMapper.updateUser(updateUserVO);
//    }
//
//    @Test
//    void selectNumByUsername() {
//        System.out.println(userMapper.selectNumByUsername("xwh"));
//    }
}
