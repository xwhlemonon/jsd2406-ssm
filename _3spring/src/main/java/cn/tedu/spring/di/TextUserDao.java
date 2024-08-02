package cn.tedu.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TextUserDao {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("cn.tedu.spring.di");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
    }
}
