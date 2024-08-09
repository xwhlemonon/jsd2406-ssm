package cn.tedu._5mvcboot02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu._5mvcboot02.mapper")
public class MybatisConfig {
}
