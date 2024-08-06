package cn.tedu._04mybatis.mapper;

import cn.tedu._04mybatis.pojo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
//    @Insert("INSERT INTO user (username, password, nickname, created) VALUES (#{username}, #{password}, #{nickname}, #{created})")
    void insert(User user);

//    @Delete("DELETE FROM user WHERE id = #{id}")
    int delete(User user);

//    @Update("UPDATE user SET username = #{username}, password = #{password}, nickname = #{nickname}, created  = #{created} WHERE id = #{id}")
    void update(User user);
}
