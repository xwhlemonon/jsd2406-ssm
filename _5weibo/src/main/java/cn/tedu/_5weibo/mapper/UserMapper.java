package cn.tedu._5weibo.mapper;

import cn.tedu._5weibo.pojo.vo.UserRegVO;
import cn.tedu._5weibo.pojo.vo.UserSelectUserVO;
import cn.tedu._5weibo.pojo.vo.UserUsernameByIdVO;

import java.util.List;

public interface UserMapper {
    List<UserSelectUserVO> selectNumByUsername(String username);

    void insertUser(UserRegVO vo);

    void deleteUser(String username);

    UserUsernameByIdVO selectNumById(Long id);
}
