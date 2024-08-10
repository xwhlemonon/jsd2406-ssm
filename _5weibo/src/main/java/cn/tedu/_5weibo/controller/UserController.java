package cn.tedu._5weibo.controller;

import cn.tedu._5weibo.mapper.UserMapper;
import cn.tedu._5weibo.pojo.dto.UserLoginDTO;
import cn.tedu._5weibo.pojo.dto.UserRegDTO;
import cn.tedu._5weibo.pojo.vo.UserRegVO;
import cn.tedu._5weibo.pojo.vo.UserSelectUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Api(tags = "01.用户模块")
@RestController
@RequestMapping("/v1/users/")
public class UserController {
    private UserMapper mapper;

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @ApiOperation(value = "注册功能")
    @PostMapping("reg")
    public String userReg(UserRegDTO dto, @ApiIgnore HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>请退出登录</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        }
        String username = dto.getUsername();
        String password = dto.getPassword();
        String nickname = dto.getNickname();
        if (username.trim().isEmpty()) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>用户名不能为空</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else if (password.trim().isEmpty()) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>密码不能为空</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else if (nickname.trim().isEmpty()) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>昵称不能为空</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else {
            List<UserSelectUserVO> user = mapper.selectNumByUsername(username);
            if (user.size() == 1) {
                return "<div style=\"text-align: center;margin-top: 30px\"><h2>用户已存在</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
            } else if (user.isEmpty()) {
                UserRegVO vo = new UserRegVO();
                vo.setUsername(username);
                vo.setPassword(password);
                vo.setNickname(nickname);
                vo.setCreated(new Date());
                mapper.insertUser(vo);
                session.setAttribute("user", username);
                return "<div style=\"text-align: center;margin-top: 30px\"><h2>注册成功</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
            } else {
                System.out.println("用户重复");
                return "<div style=\"text-align: center;margin-top: 30px\"><h2>系统错误</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
            }
        }
    }

    @ApiOperation(value = "登录功能")
    @PostMapping("login")
    public String userCurrent(UserLoginDTO dto, @ApiIgnore HttpSession session) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        List<UserSelectUserVO> user = mapper.selectNumByUsername(username);
        if (user.size() == 1) {
            if (user.get(0).getPassword().equals(password)) {
                session.setAttribute("user", username);
                return "<div style=\"text-align: center;margin-top: 30px\"><h2>登录成功</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
            } else {
                return "<div style=\"text-align: center;margin-top: 30px\"><h2>密码错误</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
            }
        } else if (user.isEmpty()) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>用户名错误</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else {
            System.out.println("用户重复");
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>系统错误</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        }
    }

    @ApiOperation(value = "在线功能")
    @GetMapping("current")
    public String userCurrent(@ApiIgnore HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user == null) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>用户未登录</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>" + user + "登录中</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        }
    }

    @ApiOperation(value = "离线功能")
    @GetMapping("outUser")
    public String outUser(@ApiIgnore HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>用户未登录</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else {
            session.removeAttribute("user");
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>已退出登录</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        }
    }

    @ApiOperation(value = "注销功能")
    @PostMapping("delete")
    public String deleteUser(@ApiIgnore HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user == null) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>未登录，请登录后再次尝试</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else {
            mapper.deleteUser(user);
            session.removeAttribute("user");
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>已注销账户并退出登录</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        }
    }

}
