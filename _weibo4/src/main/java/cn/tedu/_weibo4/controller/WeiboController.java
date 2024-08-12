package cn.tedu._weibo4.controller;

import cn.tedu._weibo4.base.response.JsonResult;
import cn.tedu._weibo4.base.response.StatusCode;
import cn.tedu._weibo4.mapper.WeiboMapper;
import cn.tedu._weibo4.pojo.entity.User;
import cn.tedu._weibo4.pojo.entity.Weibo;
import cn.tedu._weibo4.pojo.vo.WeiboByIdVO;
import cn.tedu._weibo4.pojo.vo.WeiboIndexVO;
import cn.tedu._weibo4.pojo.vo.WeiboInsertVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = "微博模块")
@RestController
@RequestMapping("/v1/weibo/")
public class WeiboController {

    private WeiboMapper weiboMapper;

    @Autowired
    public void setWeiboMapper(WeiboMapper weiboMapper) {
        this.weiboMapper = weiboMapper;
    }

    @PostMapping("insert")
    @ApiOperation(value = "发布微博")
    @ApiImplicitParam(name = "content", value = "微博内容", required = true)
    public JsonResult weiboInsert(String content, @ApiIgnore @CookieValue(value = "username", required = false) String usernameCookie, @ApiIgnore HttpSession session) {
        if (usernameCookie != null && session.getAttribute(usernameCookie) != null) {
            WeiboInsertVO vo = new WeiboInsertVO();
            vo.setContent(content);
            vo.setCreated(new Date());
            User user = (User) session.getAttribute(usernameCookie);
            vo.setUserId(user.getId());
            weiboMapper.weiboInsert(vo);
            return JsonResult.ok();
        } else {
            return new JsonResult(StatusCode.NOT_LOGIN);
        }
    }

    @GetMapping("selectIndex")
    @ApiOperation(value = "微博列表")
    public JsonResult weiboIndex() {
        List<WeiboIndexVO> vo = weiboMapper.weiboIndex();
        return new JsonResult(StatusCode.OPERATION_SUCCESS, vo);
    }

    @GetMapping("selectById")
    @ApiOperation(value = "微博详情页")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id", value = "微博编号", required = true), @ApiImplicitParam(name = "username", value = "用户名", required = true)})
    public JsonResult weiboById(Integer id, @ApiIgnore @CookieValue(value = "username", required = false) String usernameCookie, @ApiIgnore HttpSession session) {
        Weibo weibo = weiboMapper.weiboById(id);
        WeiboByIdVO vo = new WeiboByIdVO();
        BeanUtils.copyProperties(weibo, vo);
        if (usernameCookie != null && session.getAttribute(usernameCookie) != null) {
            User users = (User) session.getAttribute(usernameCookie);
            vo.setNickname(users.getNickname());
            return new JsonResult(StatusCode.OPERATION_SUCCESS, vo);
        } else {
            return new JsonResult(StatusCode.NOT_LOGIN, vo);
        }
    }

}
