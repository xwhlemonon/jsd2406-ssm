package cn.tedu._5springmvc.controller;

import cn.tedu._5springmvc.pojo.dto.UserRegDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @RequestMapping("/v1/users/login")
    @ResponseBody
    public String login() {
        return "登陆成功···";
    }

    @RequestMapping("/v1/users/login/reg1")
    @ResponseBody
    public String loginReg1(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return username + "注册成功···";
    }

    @RequestMapping("/v1/users/login/reg2")
    @ResponseBody
    public String loginReg2(String username, String password) {
        return username + "---" + password;
    }

    @RequestMapping("/v1/users/login/reg3")
    @ResponseBody
    public String loginReg3(UserRegDTO userRegDTO) {
        String username = userRegDTO.getUsername();
        String password = userRegDTO.getPassword();
        return username + "***" + password;
    }

}
