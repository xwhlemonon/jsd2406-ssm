package cn.tedu.egaddress01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.egaddress01.mapper")
public class MybatisConfig {
}
