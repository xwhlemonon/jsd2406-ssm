package cn.tedu._weibo4.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentByWeiboIdVO {

    private String content;
    private Date created;
    private Long weiboId;
    private String nickname;

}
