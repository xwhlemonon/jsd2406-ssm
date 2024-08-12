package cn.tedu._weibo4.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu._weibo4.mapper")
public class MybatisConfig {
}
