package cn.tedu._5weibo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu._5weibo.mapper")
public class MybatisConfig {
}
