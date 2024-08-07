package cn.tedu.egmybatis6.mapper;

import cn.tedu.egmybatis6.pojo.entity.Customers;
import cn.tedu.egmybatis6.pojo.vo.CustomersVO1;
import cn.tedu.egmybatis6.pojo.vo.CustomersVO2;
import cn.tedu.egmybatis6.pojo.vo.CustomersVO3;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomersMapper {
    void insertCust(Customers cust);

    CustomersVO1 selectByCustId(String custId);

    List<CustomersVO2> selectByCity(String city);

    CustomersVO3 selectByCustOfList(String custId);
}
