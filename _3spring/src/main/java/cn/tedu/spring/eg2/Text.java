package cn.tedu.spring.eg2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Text {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("cn.tedu.spring.eg2");
        CommentMapper commentMapper = context.getBean(CommentMapper.class);
        System.out.println(commentMapper);
    }
}
