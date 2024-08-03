package cn.tedu.spring.eg3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class ShopController {
    private String shop;

    public ShopController() {
        System.out.println("构造方法");
    }

    public String getShop() {
        return shop;
    }

    @Value("金刚")
    public void setShop(String shop) {
        System.out.println("set注入");
        this.shop = shop;
    }

    @Override
    public String toString() {
        return shop;
    }

    @PostConstruct
    public void into() {
        System.out.println("生命周期开始");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("生命周期结束");
    }
}
