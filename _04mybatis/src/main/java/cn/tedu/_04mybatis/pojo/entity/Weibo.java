package cn.tedu._04mybatis.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Weibo {
    private Long id;
    private String content;
    private Date created;
    private Long userId;
}
