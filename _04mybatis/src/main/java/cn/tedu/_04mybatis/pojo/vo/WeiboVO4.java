package cn.tedu._04mybatis.pojo.vo;

import cn.tedu._04mybatis.pojo.entity.Weibo;
import lombok.Data;

import java.util.List;

@Data
public class WeiboVO4 {
    private Long id;
    private String nickname;
    private List<Weibo> weiboList;
}
