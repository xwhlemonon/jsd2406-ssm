package cn.tedu.spring.config;

import cn.tedu.spring.di.UserDao;
import cn.tedu.spring.file.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TextSpringConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Database database = context.getBean(Database.class);
        System.out.println(database);
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        exit(context);
    }

    public static void exit(ApplicationContext context) {
        ((AnnotationConfigApplicationContext) context).close();
    }
}
