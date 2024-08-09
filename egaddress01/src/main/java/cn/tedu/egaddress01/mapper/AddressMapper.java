package cn.tedu.egaddress01.mapper;

import cn.tedu.egaddress01.pojo.dto.AddressNoIdDTO;
import cn.tedu.egaddress01.pojo.entity.Address;

import java.util.List;

public interface AddressMapper {
    List<Address> selectAddress();

    void insertAddress(AddressNoIdDTO dto);

    void updateAddress(Address address);

    void deleteAddress(Integer id);
}
