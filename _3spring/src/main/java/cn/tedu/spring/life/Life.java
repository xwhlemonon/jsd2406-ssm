package cn.tedu.spring.life;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class Life {
    private String meaning;

    public Life() {
        System.out.println("无参构造");
    }

    public Life(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    @Value("666")
    public void setMeaning(String meaning) {
        System.out.println("set方法");
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Life{" + "meaning='" + meaning + '\'' + '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("生命周期初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁了");
    }
}
