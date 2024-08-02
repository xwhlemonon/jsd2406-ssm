package cn.tedu.spring.eg1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Product {
    @Value("西瓜")
    private String title;
    @Value("10")
    private Integer num;
    private String comment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getComment() {
        return comment;
    }

    @Value("这是一个西瓜")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Product{" + "title='" + title + '\'' + ", num=" + num + ", comment='" + comment + '\'' + '}';
    }
}
