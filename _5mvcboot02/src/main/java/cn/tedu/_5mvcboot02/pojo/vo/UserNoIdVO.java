package cn.tedu._5mvcboot02.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserNoIdVO {
    private String username;
    private String password;
    private String nickname;
    private Date created;
}
