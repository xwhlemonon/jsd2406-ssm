package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo4 {
    public JDBCDemo4() {
        try (Connection connection = JDBCUtil.getConnection(); Statement statement = connection.createStatement()) {
            run(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new JDBCDemo4();
    }

    private void run(Statement statement) throws SQLException {
        String sql = "SELECT userinfo.username, userinfo.password, userinfo.age FROM userinfo";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            int age = rs.getInt("age");
            System.out.println(username + "\t" + password + "\t" + age);
        }
    }
}
