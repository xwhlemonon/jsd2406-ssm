package cn.tedu._5mvcboot02.pojo.dto;

import lombok.Data;

@Data
public class UpdateUserDTO {
    private String username;
    private String password;
    private String newPassword;
    private String nickname;
}
