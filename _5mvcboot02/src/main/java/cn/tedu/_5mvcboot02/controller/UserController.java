package cn.tedu._5mvcboot02.controller;

import cn.tedu._5mvcboot02.mapper.UserMapper;
import cn.tedu._5mvcboot02.pojo.dto.DeleteUserDTO;
import cn.tedu._5mvcboot02.pojo.dto.InsertUserDTO;
import cn.tedu._5mvcboot02.pojo.dto.UpdateUserDTO;
import cn.tedu._5mvcboot02.pojo.vo.InsertUserVO;
import cn.tedu._5mvcboot02.pojo.vo.UpdateUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @RequestMapping("insertUser")
    public String insertUser(InsertUserDTO insertUserDTO) {
        if (userMapper.selectNumByUsername(insertUserDTO.getUsername()) == 0) {
            InsertUserVO insertUserVO = new InsertUserVO();
            insertUserVO.setUsername(insertUserDTO.getUsername());
            insertUserVO.setPassword(insertUserDTO.getPassword());
            insertUserVO.setNickname(insertUserDTO.getNickname());
            insertUserVO.setCreated(new Date());
            userMapper.insertUser(insertUserVO);
            return "用户" + insertUserVO.getUsername() + "注册成功···";
        } else {
            return "用户名已存在···";
        }
    }

    @RequestMapping("deleteUser")
    public String delete(DeleteUserDTO deleteUserDTO) {
        List<Integer> list = userMapper.selectByUsernamePassword(deleteUserDTO);
        if (!list.isEmpty()) {
            for (Integer integer : list) {
                userMapper.deleteUser(integer);
            }
            return "删除成功···";
        } else {
            return "用户名或密码错误···";
        }
    }

    @RequestMapping("updateUser")
    public String update(UpdateUserDTO updateUserDTO) {
        DeleteUserDTO deleteUserDTO = new DeleteUserDTO();
        deleteUserDTO.setUsername(updateUserDTO.getUsername());
        deleteUserDTO.setPassword(updateUserDTO.getPassword());
        List<Integer> list = userMapper.selectByUsernamePassword(deleteUserDTO);
        if (!list.isEmpty()) {
            UpdateUserVO updateUserVO = new UpdateUserVO();
            updateUserVO.setId(list.get(0));
            String password = updateUserDTO.getNewPassword();
            String nickname = updateUserDTO.getNickname();
            if (password != null && !password.isEmpty()) {
                updateUserVO.setPassword(password);
            }
            if (nickname != null && !nickname.isEmpty()) {
                updateUserVO.setNickname(nickname);
            }
            updateUserVO.setCreated(new Date());
            userMapper.updateUser(updateUserVO);
            return "修改成功···";
        } else {
            return "用户名或密码错误···";
        }
    }

    @RequestMapping("login")
    public String userLogin(DeleteUserDTO deleteUserDTO) {
        if (userMapper.selectLogin(deleteUserDTO) == 1) {
            return "登录成功···";
        } else {
            return "用户名或密码错误···";
        }
    }

}
