package cn.tedu._weibo4.mapper;

import cn.tedu._weibo4.pojo.entity.User;
import cn.tedu._weibo4.pojo.vo.UserRegVO;

import java.util.List;

public interface UserMapper {

    List<User> selectUserByUsername(String username);

    void userReg(UserRegVO vo);

}
