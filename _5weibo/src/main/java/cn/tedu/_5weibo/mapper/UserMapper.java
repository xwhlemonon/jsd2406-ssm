package cn.tedu._5weibo.mapper;

import cn.tedu._5weibo.pojo.vo.UserRegVO;
import cn.tedu._5weibo.pojo.vo.UserSelectUserVO;

import java.util.List;

public interface UserMapper {
    List<UserSelectUserVO> selectNumByUsername(String username);

    void insertUser(UserRegVO vo);


}
