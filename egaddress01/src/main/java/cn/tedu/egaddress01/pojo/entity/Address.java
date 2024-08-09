package cn.tedu.egaddress01.pojo.entity;

import lombok.Data;

@Data
public class Address {
    private Integer id;
    private String receiver;
    private String address;
    private String email;
    private String mobile;
    private String tag;
}
