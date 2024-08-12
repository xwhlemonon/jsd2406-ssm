package cn.tedu._weibo4.controller;

import cn.tedu._weibo4.base.response.JsonResult;
import cn.tedu._weibo4.base.response.StatusCode;
import cn.tedu._weibo4.mapper.CommentMapper;
import cn.tedu._weibo4.pojo.dto.CommentInsertDTO;
import cn.tedu._weibo4.pojo.entity.User;
import cn.tedu._weibo4.pojo.vo.CommentByWeiboIdVO;
import cn.tedu._weibo4.pojo.vo.CommentInsertVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = "评论模块")
@RestController
@RequestMapping("/v1/comment/")
public class CommentController {

    private CommentMapper commentMapper;


    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @PostMapping("insert")
    @ApiOperation(value = "发布评论")
    public JsonResult commentInsert(CommentInsertDTO dto, @ApiIgnore @CookieValue(value = "username", required = false) String usernameCookie, @ApiIgnore HttpSession session) {
        if (usernameCookie != null && session.getAttribute(usernameCookie) != null) {
            CommentInsertVO vo = new CommentInsertVO();
            vo.setContent(dto.getContent());
            vo.setCreated(new Date());
            User user = (User) session.getAttribute(usernameCookie);
            vo.setUserId(user.getId());
            vo.setWeiboId(dto.getWeiboId());
            commentMapper.commentInsert(vo);
            return JsonResult.ok(vo);
        } else {
            return new JsonResult(StatusCode.NOT_LOGIN);
        }
    }

    @GetMapping("selectByWeiboId")
    @ApiOperation(value = "评论列表")
    @ApiImplicitParam(name = "weiboId", value = "微博编号", required = true, dataType = "int")
    public JsonResult selectWeibo(Integer weiboId) {
        List<CommentByWeiboIdVO> vo = commentMapper.selectWeibo(weiboId);
        return JsonResult.ok(vo);
    }

}
