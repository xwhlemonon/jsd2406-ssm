package cn.tedu.jrdemo.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.jrdemo.mapper")
public class MybatisConfig {
}
