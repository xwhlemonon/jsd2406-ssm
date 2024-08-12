package cn.tedu._weibo4.base.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusCode {

    NOT_LOGIN(1000, "未登录"), PASSWORD_ERROR(1001, "密码错误"), USERNAME_ERROR(1002, "用户名错误"), USERNAME_EXIST(1003, "用户名被占用"), OPERATION_SUCCESS(2001, "操作成功"), OPERATION_FAILED(2002, "操作失败");

    private Integer state;
    private String massage;

}
