package cn.tedu.egmybatis4;

import cn.tedu.egmybatis4.mapper.ProductMapper;
import cn.tedu.egmybatis4.mybatis.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("大以");
        product.setPrice(10.5);
        product.setStock(150);

//        productMapper.insertProduct(product);
//        productMapper.updateProduct(product);
//        productMapper.deleteProduct(4);

//        System.out.println(productMapper.selectProductById(1));

        System.out.println(productMapper.selectAllProduct());
    }

}
