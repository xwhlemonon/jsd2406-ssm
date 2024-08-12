package cn.tedu._weibo4.controller;

import cn.tedu._weibo4.base.response.JsonResult;
import cn.tedu._weibo4.base.response.StatusCode;
import cn.tedu._weibo4.mapper.UserMapper;
import cn.tedu._weibo4.pojo.dto.UserLoginDTO;
import cn.tedu._weibo4.pojo.dto.UserRegDTO;
import cn.tedu._weibo4.pojo.entity.User;
import cn.tedu._weibo4.pojo.vo.UserRegVO;
import cn.tedu._weibo4.pojo.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = "用户模块")
@RestController
@RequestMapping("/v1/users/")
public class UserController {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("reg")
    @ApiOperation(value = "注册功能")
    public JsonResult userReg(UserRegDTO dto) {
        List<User> users = userMapper.selectUserByUsername(dto.getUsername());
        if (users.isEmpty()) {
            UserRegVO vo = new UserRegVO();
            BeanUtils.copyProperties(dto, vo);
            vo.setCreated(new Date());
            userMapper.userReg(vo);
            return JsonResult.ok();
        } else {
            return new JsonResult(StatusCode.USERNAME_EXIST);
        }
    }

    @PostMapping("login")
    @ApiOperation(value = "登录功能")
    public JsonResult userLogin(UserLoginDTO dto, @ApiIgnore @CookieValue(value = "username", required = false) String usernameCookie, @ApiIgnore HttpSession session, @ApiIgnore HttpServletResponse response) {
        if (usernameCookie != null && session.getAttribute(usernameCookie) != null) {
            return new JsonResult(StatusCode.OPERATION_FAILED);
        }
        List<User> users = userMapper.selectUserByUsername(dto.getUsername());
        if (users.size() == 1) {
            if (users.get(0).getPassword().equals(dto.getPassword())) {
                Cookie cookie = new Cookie("username", dto.getUsername());
                cookie.setMaxAge(60 * 60 * 60);
                cookie.setHttpOnly(true);
                cookie.setPath("/");
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

    @GetMapping("currentUser")
    @ApiOperation(value = "获取登录用户")
    public JsonResult userCurrent(@ApiIgnore @CookieValue(value = "username", required = false) String usernameCookie, @ApiIgnore HttpSession session) {
        if (usernameCookie != null && session.getAttribute(usernameCookie) != null) {
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(session.getAttribute(usernameCookie), vo);
            return new JsonResult(StatusCode.OPERATION_SUCCESS, vo);
        } else {
            return new JsonResult(StatusCode.NOT_LOGIN);
        }
    }

    @GetMapping("logout")
    @ApiOperation(value = "退出登录")
    public void userLogout(@ApiIgnore @CookieValue(value = "username", required = false) String usernameCookie, @ApiIgnore HttpSession session) {
        session.removeAttribute(usernameCookie);
    }

}
