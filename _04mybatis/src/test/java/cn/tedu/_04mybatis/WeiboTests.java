package cn.tedu._04mybatis;

import cn.tedu._04mybatis.mapper.WeiboMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeiboTests {

    @Autowired
    private WeiboMapper weiboMapper;

    @Test
    void insertTest() {
//        Weibo weibo = new Weibo();
//        weibo.setId(205L);
//        weibo.setContent("你好666");
//        weibo.setCreated(new Date());
//        weibo.setUserId(101L);

//        weiboMapper.insert(weibo);
//        System.out.println(weiboMapper.delete(205L));
//        weiboMapper.update(weibo);

//        System.out.println(weiboMapper.select(200L));

//        System.out.println(weiboMapper.selectByUserId(101L));

//        System.out.println(weiboMapper.selectWeiboVO1ById(200L));

        System.out.println(weiboMapper.selectWeiboVO2());

    }

}
