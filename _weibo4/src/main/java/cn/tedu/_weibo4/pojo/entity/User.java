package cn.tedu._weibo4.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Date created;

}
