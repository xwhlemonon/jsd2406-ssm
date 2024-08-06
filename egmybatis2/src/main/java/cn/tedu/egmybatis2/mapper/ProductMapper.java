package cn.tedu.egmybatis2.mapper;

import cn.tedu.egmybatis2.pojo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    void insert(Product product);

    int delete(Integer id);

    void update(Product product);

    Product selectById(Integer id);

    List<Product> selectProductVO1ByStock(Integer stock);
}
