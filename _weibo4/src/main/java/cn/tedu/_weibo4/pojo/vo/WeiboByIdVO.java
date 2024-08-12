package cn.tedu._weibo4.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class WeiboByIdVO {

    private Long id;
    private String content;
    private Date created;
    private String nickname;

}
