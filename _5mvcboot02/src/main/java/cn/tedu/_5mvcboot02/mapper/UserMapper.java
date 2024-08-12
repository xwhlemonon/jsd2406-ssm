package cn.tedu._5mvcboot02.mapper;

import cn.tedu._5mvcboot02.pojo.entity.User;
import cn.tedu._5mvcboot02.pojo.vo.UserRegVO;

import java.util.List;

public interface UserMapper {

    void userReg(UserRegVO vo);

    List<User> selectUserByUsername(String username);

    void userLogoff(String username);

}
