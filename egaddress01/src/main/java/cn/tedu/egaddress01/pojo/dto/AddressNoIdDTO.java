package cn.tedu.egaddress01.pojo.dto;

import lombok.Data;

@Data
public class AddressNoIdDTO {
    private String receiver;
    private String address;
    private String email;
    private String mobile;
    private String tag;
}
