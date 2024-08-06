package cn.tedu._04mybatis.pojo.vo;

import cn.tedu._04mybatis.pojo.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentVO3 {
    private Long id;
    private List<Comment> comments;
}
