package cn.tedu._5mvcboot02.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserUpdateDTO {
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "新密码", required = true)
    private String newPassword;
    @ApiModelProperty(value = "昵称", required = true)
    private String nickname;
}
