package cn.tedu._5mvcboot02.mapper;

import cn.tedu._5mvcboot02.pojo.dto.DeleteUserDTO;
import cn.tedu._5mvcboot02.pojo.entity.User;
import cn.tedu._5mvcboot02.pojo.vo.InsertUserVO;
import cn.tedu._5mvcboot02.pojo.vo.UpdateUserVO;
import cn.tedu._5mvcboot02.pojo.vo.UserNoIdVO;

import java.util.List;

public interface UserMapper {
    void insertUser(InsertUserVO insertUserVO);

    void deleteUser(Integer id);

    void updateUser(UpdateUserVO updateUserVO);

    int selectNumByUsername(String username);

    List<Integer> selectByUsernamePassword(DeleteUserDTO deleteUserDTO);

    int selectLogin(DeleteUserDTO deleteUserDTO);

    List<User> selectUser();

    UserNoIdVO selectNoId(Integer id);
}
