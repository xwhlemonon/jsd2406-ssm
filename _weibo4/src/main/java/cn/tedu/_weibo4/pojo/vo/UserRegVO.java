package cn.tedu._weibo4.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserRegVO {

    private String username;
    private String password;
    private String nickname;
    private Date created;

}
