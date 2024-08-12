package cn.tedu._weibo4.mapper;

import cn.tedu._weibo4.pojo.vo.CommentByWeiboIdVO;
import cn.tedu._weibo4.pojo.vo.CommentInsertVO;

import java.util.List;

public interface CommentMapper {

    void commentInsert(CommentInsertVO vo);

    List<CommentByWeiboIdVO> selectWeibo(Integer weiboId);

}
