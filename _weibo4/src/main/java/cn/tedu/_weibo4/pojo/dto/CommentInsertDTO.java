package cn.tedu._weibo4.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentInsertDTO {

    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
    @ApiModelProperty(value = "微博ID", required = true)
    private Long weiboId;

}
