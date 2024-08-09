package cn.tedu._5mvcboot02.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Date created;
}
