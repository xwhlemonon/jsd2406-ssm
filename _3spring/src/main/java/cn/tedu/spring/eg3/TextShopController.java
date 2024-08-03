package cn.tedu.spring.eg3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TextShopController {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.tedu.spring.eg3");
        ShopController shopController = context.getBean(ShopController.class);
        System.out.println(shopController);
        context.close();
    }
}
