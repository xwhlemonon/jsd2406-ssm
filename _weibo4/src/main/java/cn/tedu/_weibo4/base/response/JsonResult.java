package cn.tedu._weibo4.base.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JsonResult {

    @ApiModelProperty(value = "内部状态码")
    private Integer state;
    @ApiModelProperty(value = "提示消息")
    private String massage;
    @ApiModelProperty(value = "响应数据")
    private Object data;

    public JsonResult(StatusCode sc, Object o) {
        this.state = sc.getState();
        this.massage = sc.getMassage();
        this.data = o;
    }

    public JsonResult(StatusCode sc) {
        this.state = sc.getState();
        this.massage = sc.getMassage();
    }

    public static JsonResult ok(Object o) {
        return new JsonResult(StatusCode.OPERATION_SUCCESS, o);
    }

    public static JsonResult ok() {
        return ok(null);
    }
}
