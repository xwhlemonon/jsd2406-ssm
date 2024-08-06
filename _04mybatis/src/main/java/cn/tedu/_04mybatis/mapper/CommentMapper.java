package cn.tedu._04mybatis.mapper;

import cn.tedu._04mybatis.pojo.entity.Comment;
import cn.tedu._04mybatis.pojo.vo.CommentVO1;
import cn.tedu._04mybatis.pojo.vo.CommentVO2;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO comment (content, created, user_id, weibo_id) VALUES (#{content}, #{created}, #{userId}, #{weiboId})")
    void insert(Comment comment);

    @Delete("DELETE FROM comment WHERE id = #{id}")
    int delete(Long id);

    @Update("UPDATE comment SET content = #{content}, created = #{created}, user_id = #{userId}, weibo_id = #{weiboId} WHERE id = #{id}")
    void update(Comment comment);

    @Select("SELECT content, user_id userId, weibo_id weiboId FROM comment WHERE id = #{id}")
    CommentVO1 selectCommentById(Long id);

    @Select("SELECT content, user_id userId FROM comment WHERE user_id = #{userId}")
    List<CommentVO2> selectCommentByUserId(Long userId);
}
