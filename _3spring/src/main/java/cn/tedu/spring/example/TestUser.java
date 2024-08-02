package cn.tedu.spring.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("cn.tedu.spring.example");
        User user = context.getBean(User.class);
        user.run();
    }
}
