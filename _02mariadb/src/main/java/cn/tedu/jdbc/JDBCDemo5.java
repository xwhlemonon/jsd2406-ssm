package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDemo5 {
    private final Scanner scanner = new Scanner(System.in);

    public JDBCDemo5() {
        try (Connection connection = JDBCUtil.getConnection()) {
            while (!run(connection)) {
                System.out.println("重试···");
            }
        } catch (SQLException e) {
            System.out.println("错误···");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new JDBCDemo5();
    }

    private boolean run(Connection connection) throws SQLException {
        System.out.println("请输入用户名：");
        String userName = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        String sql = "SELECT userinfo.username, userinfo.password FROM userinfo WHERE username = ? AND password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            System.out.println("欢迎" + userName + "···");
            return true;
        } else {
            System.out.println("登录失败···");
            return false;
        }
    }
}
