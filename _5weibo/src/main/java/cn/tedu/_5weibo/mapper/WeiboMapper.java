package cn.tedu._5weibo.mapper;

import cn.tedu._5weibo.pojo.entity.Weibo;
import cn.tedu._5weibo.pojo.vo.WeiboInsertVO;

import java.util.List;

public interface WeiboMapper {
    void insertWeibo(WeiboInsertVO vo);

    List<Weibo> selectWeibo();
}
