package cn.tedu.jrdemo.base.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JsonResult {
    @ApiModelProperty(value = "响应码")
    private Integer state;
    @ApiModelProperty(value = "响应消息")
    private String massage;
    @ApiModelProperty(value = "返回数据")
    private Object data;

    public JsonResult(StatusCode sc, Object o) {
        state = sc.getState();
        massage = sc.getMassage();
        data = o;
    }

    public JsonResult(StatusCode sc) {
        state = sc.getState();
        massage = sc.getMassage();
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(StatusCode.OK, data);
    }

    public static JsonResult ok() {
        return JsonResult.ok(null);
    }

}
