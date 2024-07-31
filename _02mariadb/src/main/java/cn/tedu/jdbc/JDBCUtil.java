package cn.tedu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
    private static final DruidDataSource dds;

    static {
        dds = new DruidDataSource();
        dds.setUrl("jdbc:mysql://localhost:3306/tedu?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        dds.setUsername("root");
        dds.setPassword("root");
        dds.setInitialSize(5);
        dds.setMaxActive(20);
    }

    public static Connection getConnection() throws SQLException {
        return dds.getConnection();
    }
}
