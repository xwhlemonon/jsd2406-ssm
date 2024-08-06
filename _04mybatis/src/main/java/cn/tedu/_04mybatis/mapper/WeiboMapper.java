package cn.tedu._04mybatis.mapper;

import cn.tedu._04mybatis.pojo.entity.Weibo;
import cn.tedu._04mybatis.pojo.vo.WeiboVO1;
import cn.tedu._04mybatis.pojo.vo.WeiboVO2;
import cn.tedu._04mybatis.pojo.vo.WeiboVO3;
import cn.tedu._04mybatis.pojo.vo.WeiboVO4;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeiboMapper {
    //    @Insert("INSERT INTO weibo (content, created, user_id) VALUES (#{content}, #{created}, #{userId})")
    void insert(Weibo weibo);

    //    @Delete("DELETE FROM weibo WHERE id = #{id}")
    int delete(Long id);

    //    @Update("UPDATE weibo SET content = #{content}, created = #{created}, user_id = #{userId} WHERE id = #{id}")
    void update(Weibo weibo);

    //    @Select("SELECT id, content, created, user_id userId FROM weibo WHERE id = #{id}")
    Weibo select(Long id);

    //    @Select("SELECT id, content, created, user_id userId FROM weibo WHERE user_id = #{userId}")
    List<Weibo> selectByUserId(Long userId);

    //    @Select("SELECT content, created FROM weibo WHERE id = #{id}")
    WeiboVO1 selectWeiboVO1ById(Long id);

    //    @Select("SELECT content, user_id userId FROM weibo")
    List<WeiboVO2> selectWeiboVO2();

    void updateDynamic(Weibo weibo);

    void deleteDynamic(Long[] id);

    void deleteDynamicList(List<Long> id);

    int selectNum();

    WeiboVO3 selectWeibo(Long id);

    WeiboVO4 selectMap(Long id);
}
