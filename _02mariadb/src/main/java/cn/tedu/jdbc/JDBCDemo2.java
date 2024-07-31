package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo2 {
    public Connection connection = null;

    public JDBCDemo2() {
        try {
            connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String userName = scanner.nextLine();
            System.out.println("请输入旧密码：");
            String oldPassword = scanner.nextLine();
            System.out.println("请输入新密码：");
            String newPassword = scanner.nextLine();
            if (statement.executeUpdate("UPDATE userinfo u SET u.password = " + newPassword + " WHERE u.username = '" + userName + "' AND u.password = " + oldPassword) == 0) {
                System.out.println("更改失败···");
            } else {
                System.out.println("更新成功···");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
//            System.out.println("更改错误···");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new JDBCDemo2();
    }
}
