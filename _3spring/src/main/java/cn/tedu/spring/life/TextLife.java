package cn.tedu.spring.life;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TextLife {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.tedu.spring.life");
        Life life = context.getBean(Life.class);
        System.out.println(life);
        context.close();
    }
}
