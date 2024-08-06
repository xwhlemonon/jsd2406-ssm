package cn.tedu.egmybatis4.mapper;

import cn.tedu.egmybatis4.mybatis.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    void insertProduct(Product product);

    void deleteProduct(Integer id);

    void updateProduct(Product product);

    Product selectProductById(Integer id);

    List<Product> selectAllProduct();
}
