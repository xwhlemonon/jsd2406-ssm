package cn.tedu.egaddress01.controller;

import cn.tedu.egaddress01.mapper.AddressMapper;
import cn.tedu.egaddress01.pojo.dto.AddressNoIdDTO;
import cn.tedu.egaddress01.pojo.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address/")
public class AddressController {

    @Autowired
    private AddressMapper mapper;

    @RequestMapping("select")
    public String selectAddress() {
        List<Address> list = mapper.selectAddress();
        if (list.isEmpty()) {
            return "无地址···";
        } else {
            return list.toString();
        }
    }

    @RequestMapping("insert")
    public String insertAddress(AddressNoIdDTO dto) {
        if (dto.getReceiver().isEmpty() || dto.getAddress().isEmpty() || dto.getEmail().isEmpty() || dto.getMobile().isEmpty() || dto.getTag().isEmpty()) {
            return "数据不能为空···";
        } else {
            mapper.insertAddress(dto);
            return "创建成功···";
        }
    }

    @RequestMapping("update")
    public String updateAddress(Address user) {
        Address add = new Address();
        Integer id = user.getId();
        String receiver = user.getReceiver();
        String address = user.getAddress();
        String email = user.getEmail();
        String mobile = user.getMobile();
        String tag = user.getTag();
        if (id == null) {
            return "请输入ID";
        } else {
            add.setId(id);
            if (receiver != null && !receiver.isEmpty()) {
                add.setReceiver(receiver);
            }
            if (address != null && !address.isEmpty()) {
                add.setAddress(address);
            }
            if (email != null && !email.isEmpty()) {
                add.setAddress(email);
            }
            if (mobile != null && !mobile.isEmpty()) {
                add.setAddress(mobile);
            }
            if (tag != null && !tag.isEmpty()) {
                add.setAddress(tag);
            }
            mapper.updateAddress(add);
            return "更新成功···";
        }
    }

    @RequestMapping("delete")
    public String deleteAddress(Integer id) {
        mapper.deleteAddress(id);
        return "删除成功···";
    }

}
