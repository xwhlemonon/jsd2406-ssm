package cn.tedu.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TextOrder {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("cn.tedu.spring.scope");
        Order order1 = context.getBean(Order.class);
        System.out.println(order1);
        Order order2 = context.getBean(Order.class);
        System.out.println(order2);
    }
}
