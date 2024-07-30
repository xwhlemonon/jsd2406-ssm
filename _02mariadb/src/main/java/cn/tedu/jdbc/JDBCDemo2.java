package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tedu?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true", "root", "root");
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
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("更改错误···");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
