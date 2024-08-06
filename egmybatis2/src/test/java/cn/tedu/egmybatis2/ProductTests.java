package cn.tedu.egmybatis2;

import cn.tedu.egmybatis2.mapper.ProductMapper;
import cn.tedu.egmybatis2.pojo.entity.Product;
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
        product.setId(2);
        product.setTitle("衣服");
        product.setPrice(20.5);
        product.setStock(500);

//        productMapper.insert(product);

//        productMapper.delete(1);

//        productMapper.update(product);

//        System.out.println(productMapper.selectById(2));

        System.out.println(productMapper.selectProductVO1ByStock(500));
    }

}
