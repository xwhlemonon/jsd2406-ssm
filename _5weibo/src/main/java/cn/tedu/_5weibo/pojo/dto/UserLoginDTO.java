package cn.tedu._5weibo.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginDTO {
    @ApiModelProperty(value = "用户名", required = true, example = "username")
    private String username;
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;
}
