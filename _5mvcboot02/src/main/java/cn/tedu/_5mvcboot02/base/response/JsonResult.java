package cn.tedu._5mvcboot02.base.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JsonResult {
    @ApiModelProperty(value = "状态码")
    private Integer state;
    @ApiModelProperty(value = "状态名")
    private String massage;
    @ApiModelProperty(value = "数据")
    private Object data;

    public JsonResult(StatusCode sc) {
        this.state = sc.getState();
        this.massage = sc.getMassage();
    }

    public JsonResult(StatusCode sc, Object data) {
        this.state = sc.getState();
        this.massage = sc.getMassage();
        this.data = data;
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(StatusCode.OPERATION_SUCCESS, data);
    }

    public static JsonResult ok() {
        return ok(null);
    }

}
