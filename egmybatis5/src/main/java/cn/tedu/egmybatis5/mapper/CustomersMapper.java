package cn.tedu.egmybatis5.mapper;

import cn.tedu.egmybatis5.pojo.entity.Customers;
import cn.tedu.egmybatis5.pojo.vo.VO3;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomersMapper {
    void insert(Customers customers);

    void delete(Integer custId);

    void update(Customers customers);

    List<VO3> select(String custId);
}
