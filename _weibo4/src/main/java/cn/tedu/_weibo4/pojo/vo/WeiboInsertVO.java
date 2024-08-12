package cn.tedu._weibo4.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class WeiboInsertVO {

    private String content;
    private Date created;
    private Long userId;

}
