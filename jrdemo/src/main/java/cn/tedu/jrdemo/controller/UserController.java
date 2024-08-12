package cn.tedu.jrdemo.controller;

import cn.tedu.jrdemo.base.response.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/users/")
@Api(tags = "模块")
public class UserController {

    @GetMapping("select")
    @ApiOperation(value = "查询")
    @ApiImplicitParam(name = "id", required = true, value = "这里是id", dataType = "int")
    public JsonResult userObj(Integer id) {
        return JsonResult.ok();
    }
}
