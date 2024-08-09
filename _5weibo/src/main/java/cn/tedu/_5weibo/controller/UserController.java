package cn.tedu._5weibo.controller;

import cn.tedu._5weibo.mapper.UserMapper;
import cn.tedu._5weibo.pojo.dto.UserLoginDTO;
import cn.tedu._5weibo.pojo.dto.UserRegDTO;
import cn.tedu._5weibo.pojo.vo.UserRegVO;
import cn.tedu._5weibo.pojo.vo.UserSelectUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    private UserMapper mapper;

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("reg")
    public String userReg(UserRegDTO dto, HttpSession session) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        String nickname = dto.getNickname();
        if (username.trim().isEmpty()) {
            return "用户名不能为空";
        } else if (password.trim().isEmpty()) {
            return "密码不能为空";
        } else if (nickname.trim().isEmpty()) {
            return "昵称不能为空";
        } else {
            List<UserSelectUserVO> user = mapper.selectNumByUsername(username);
            if (user.size() == 1) {
                return "用户已存在";
            } else if (user.isEmpty()) {
                UserRegVO vo = new UserRegVO();
                vo.setUsername(username);
                vo.setPassword(password);
                vo.setNickname(nickname);
                vo.setCreated(new Date());
                mapper.insertUser(vo);
                session.setAttribute("user", username);
                return "注册成功";
            } else {
                System.out.println("用户重复");
                return "系统错误";
            }
        }
    }

    @PostMapping("login")
    public String userCurrent(UserLoginDTO dto, HttpSession session) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        List<UserSelectUserVO> user = mapper.selectNumByUsername(username);
        if (user.size() == 1) {
            if (user.get(0).getPassword().equals(password)) {
                session.setAttribute("user", username);
                return "登录成功";
            } else {
                return "密码错误";
            }
        } else if (user.isEmpty()) {
            return "用户名错误";
        } else {
            System.out.println("用户重复");
            return "系统错误";
        }
    }

    @GetMapping("current")
    public String userCurrent(HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user == null) {
            return "用户未登录";
        } else {
            return user + "登录中";
        }
    }

    @GetMapping("outUser")
    public String outUser(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "用户未登录";
        } else {
            session.removeAttribute("user");
            return "已退出登录";
        }
    }

    @PostMapping("delete")
    public String deleteUser(HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user == null) {
            return "未登录";
        } else {
            mapper.deleteUser(user);
            session.removeAttribute("user");
            return "已注销账户并退出登录";
        }
    }

}
