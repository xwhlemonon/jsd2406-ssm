package cn.tedu._04mybatis;

import cn.tedu._04mybatis.mapper.WeiboMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class WeiboTests {

    @Autowired
    private WeiboMapper weiboMapper;

    @Test
    void insertTest() {
//        Weibo weibo = new Weibo();
//        weibo.setId(201L);
//        weibo.setContent("这是我的第一条微博");
//        weibo.setCreated(new Date());

//        weiboMapper.insert(weibo);
//        System.out.println(weiboMapper.delete(205L));
//        weiboMapper.update(weibo);

//        System.out.println(weiboMapper.select(200L));

//        System.out.println(weiboMapper.selectByUserId(101L));

//        System.out.println(weiboMapper.selectWeiboVO1ById(200L));

//        System.out.println(weiboMapper.selectWeiboVO2());
//        weiboMapper.updateDynamic(weibo);
//        Long[] id = {206L, 207L};
//        weiboMapper.deleteDynamic(id);
        List<Long> list = new ArrayList<>();
//        list.add(208L);
//        list.add(209L);
        list.add(203L);
        list.add(204L);
        weiboMapper.deleteDynamicList(list);

//        System.out.println(weiboMapper.selectNum());
    }

}
