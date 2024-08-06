package cn.tedu._04mybatis;

import cn.tedu._04mybatis.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentTests {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    void insertTest() {
//        Comment comment = new Comment();
//        comment.setId(305L);
//        comment.setContent("你好");
//        comment.setCreated(new Date());
//        comment.setUserId(100L);
//        comment.setWeiboId(200L);

//        commentMapper.insert(comment);
//        System.out.println(commentMapper.delete(comment));
//        commentMapper.update(comment);

//        System.out.println(commentMapper.selectCommentById(301L));

//        System.out.println(commentMapper.selectCommentByUserId(101L));
        System.out.println(commentMapper.selectMap(201L));
    }

}
