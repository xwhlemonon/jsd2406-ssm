package cn.tedu._5mvcboot02.controller;

import cn.tedu._5mvcboot02.base.response.JsonResult;
import cn.tedu._5mvcboot02.base.response.StatusCode;
import cn.tedu._5mvcboot02.mapper.UserMapper;
import cn.tedu._5mvcboot02.pojo.dto.UserLoginDTO;
import cn.tedu._5mvcboot02.pojo.dto.UserRegDTO;
import cn.tedu._5mvcboot02.pojo.entity.User;
import cn.tedu._5mvcboot02.pojo.vo.UserRegVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = "01_用户模块")
@RestController
@RequestMapping("/v1/users/")
public class UserController {

    public UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @ApiOperation("注册功能")
    @PostMapping("reg")
    public JsonResult userReg(UserRegDTO dto) {
        if (userMapper.selectUserByUsername(dto.getUsername()).isEmpty()) {
            UserRegVO vo = new UserRegVO();
            BeanUtils.copyProperties(dto, vo);
            vo.setCreated(new Date());
            userMapper.userReg(vo);
            return JsonResult.ok();
        } else {
            return new JsonResult(StatusCode.USERNAME_EXIST);
        }
    }

    @ApiOperation("登录功能")
    @PostMapping("login")
    public JsonResult userLogin(UserLoginDTO dto, @CookieValue(value = "username", required = false) String usernameCookie, @ApiIgnore HttpSession session, @ApiIgnore HttpServletResponse response) {
        if (usernameCookie != null && session.getAttribute(usernameCookie) != null) {
            return new JsonResult(StatusCode.OPERATION_FAILED);
        }
        List<User> users = userMapper.selectUserByUsername(dto.getUsername());
        if (users.size() == 1) {
            if (users.get(0).getPassword().equals(dto.getPassword())) {
                Cookie cookie = new Cookie("username", dto.getUsername());
                cookie.setMaxAge(60 * 60);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                session.setAttribute(dto.getUsername(), users.get(0));
                return JsonResult.ok();
            } else {
                return new JsonResult(StatusCode.PASSWORD_ERROR);
            }
        } else {
            return new JsonResult(StatusCode.USERNAME_ERROR);
        }
    }

    @ApiOperation("注销功能")
    @PostMapping("logoff")
    public JsonResult delete(@CookieValue(value = "username", required = false) String usernameCookie, HttpSession session) {
        if (usernameCookie == null || session.getAttribute(usernameCookie) == null) {
            return new JsonResult(StatusCode.NOT_LOGIN);
        }
        userMapper.userLogoff(usernameCookie);
        session.removeAttribute(usernameCookie);
        return JsonResult.ok();
    }
//
//    @ApiOperation("修改用户名或密码")
//    @PostMapping("updateUser")
//    public String update(UpdateUserDTO updateUserDTO) {
//        DeleteUserDTO deleteUserDTO = new DeleteUserDTO();
//        deleteUserDTO.setUsername(updateUserDTO.getUsername());
//        deleteUserDTO.setPassword(updateUserDTO.getPassword());
//        List<Integer> list = userMapper.selectByUsernamePassword(deleteUserDTO);
//        if (!list.isEmpty()) {
//            UpdateUserVO updateUserVO = new UpdateUserVO();
//            updateUserVO.setId(list.get(0));
//            String password = updateUserDTO.getNewPassword();
//            String nickname = updateUserDTO.getNickname();
//            if (password != null && !password.isEmpty()) {
//                updateUserVO.setPassword(password);
//            }
//            if (nickname != null && !nickname.isEmpty()) {
//                updateUserVO.setNickname(nickname);
//            }
//            updateUserVO.setCreated(new Date());
//            userMapper.updateUser(updateUserVO);
//            return "修改成功···";
//        } else {
//            return "用户名或密码错误···";
//        }
//    }
//

//
//    @ApiOperation("查询用户")
//    @GetMapping("list")
//    public String selectUser() {
//        List<User> users = userMapper.selectUser();
//        return users.toString();
//    }

}
