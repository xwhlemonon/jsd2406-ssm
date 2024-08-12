package cn.tedu._5weibo.controller;

import cn.tedu._5weibo.mapper.UserMapper;
import cn.tedu._5weibo.mapper.WeiboMapper;
import cn.tedu._5weibo.pojo.entity.Weibo;
import cn.tedu._5weibo.pojo.vo.UserSelectUserVO;
import cn.tedu._5weibo.pojo.vo.UserUsernameByIdVO;
import cn.tedu._5weibo.pojo.vo.WeiboInsertVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Api(tags = "02.微博模块")
@RestController
@RequestMapping("/v1/weibo/")
public class WeiboController {
    private WeiboMapper mapper;
    private UserMapper userMapper;

    @Autowired
    public void setMapper(WeiboMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @ApiOperation("发布微博")
    @PostMapping("insert")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "content", value = "微博编号", required = true, dataType = "string"), @ApiImplicitParam(name = "text", value = "测试", required = true, dataType = "long")})
    public String insertWeibo(String content, Long text, @ApiIgnore HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user == null) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>未登录，请登录后再次尝试</h2><br><form action=\"/login.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else if (content == null || content.trim().isEmpty()) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>内容不能为空</h2><br><form action=\"/insertWeibo.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else {
            List<UserSelectUserVO> users = userMapper.selectNumByUsername(user);
            WeiboInsertVO vo = new WeiboInsertVO();
            vo.setContent(content);
            vo.setCreated(new Date());
            vo.setUserId(users.get(0).getId());
            mapper.insertWeibo(vo);
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>发布成功</h2><br><form action=\"/insertWeibo.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        }
    }

    @ApiOperation("查看微博")
    @GetMapping("weibo")
    public String weibo() {
        List<Weibo> weibo = mapper.selectWeibo();
        if (weibo.isEmpty()) {
            return "<div style=\"text-align: center;margin-top: 30px\"><h2>没有任何微博</h2><br><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div>";
        } else {
            StringBuilder msg = new StringBuilder();
            Collections.reverse(weibo);
            msg.append("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>微博</title></head><body style=\"text-align: center\"><h1>微博页面</h1><br><div style=\"margin-top: 30px\">");
            for (Weibo weiboTemp : weibo) {
                UserUsernameByIdVO user = userMapper.selectNumById(weiboTemp.getUserId());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(user.getCreated());
                msg.append("<p style=\"display: inline-block;text-align: left;width: 25%;margin: 0 auto;border: 2px solid #000; padding: 10px; background-color: #f9f9f9\">").append(weiboTemp.getContent()).append("</p><br><h6>发布者：").append(user.getUsername()).append("</h6><h6>发布于：").append(time).append("</h6><br><br>");
            }
            msg.append("<br><div style=\"position: fixed;top: 30px;left: 30px\"><form action=\"/index.html\"><input type=\"submit\" value=\"返回\"></form></div></div></body></html>");
            return msg.toString();
        }
    }

}
