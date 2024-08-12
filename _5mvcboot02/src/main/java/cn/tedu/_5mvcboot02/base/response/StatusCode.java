package cn.tedu._5mvcboot02.base.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusCode {
    USERNAME_ERROR(1000, "用户名错误"), PASSWORD_ERROR(1001, "密码错误"), USERNAME_EXIST(1002, "用户名被占用"), NOT_LOGIN(1003, "未登录"), OPERATION_SUCCESS(2001, "操作成功"), OPERATION_FAILED(2002, "操作失败"), USERNAME_NOT_FOUND(3001, "用户名为空"), PASSWORD_NOT_FOUND(3002, "密码为空"), NICKNAME_NOT_FOUND(3003, "昵称为空");
    private Integer state;
    private String massage;
}
