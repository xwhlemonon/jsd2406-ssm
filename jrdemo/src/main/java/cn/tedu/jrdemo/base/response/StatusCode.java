package cn.tedu.jrdemo.base.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusCode {
    OK(5000, "操作成功"), ERROR(6000, "操作失败");
    private Integer state;
    private String massage;
}
