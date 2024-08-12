package cn.tedu._weibo4.mapper;

import cn.tedu._weibo4.pojo.entity.Weibo;
import cn.tedu._weibo4.pojo.vo.WeiboIndexVO;
import cn.tedu._weibo4.pojo.vo.WeiboInsertVO;

import java.util.List;

public interface WeiboMapper {

    void weiboInsert(WeiboInsertVO vo);

    List<WeiboIndexVO> weiboIndex();

    Weibo weiboById(Integer id);

}
