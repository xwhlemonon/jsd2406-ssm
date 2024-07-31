package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCReg {
    public JDBCReg() {
        try {
            Connection connection = JDBCUtil.getConnection();
            run(connection);
        } catch (SQLException e) {
            System.out.println("数据库错误···");
        }
    }

    public static void main(String[] args) {
        new JDBCReg();
    }

    public void run(Connection connection) throws SQLException {
        Scanner scan = new Scanner(System.in);
        String sql = "SELECT userinfo.username FROM userinfo";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        System.out.println("请输入用户名：");
        String username = scan.nextLine();
        while (resultSet.next()) {
            if (username.equals(resultSet.getString("username"))) {
                System.out.println("用户名已存在···");
                return;
            }
        }
        System.out.println("请输入密码：");
        String password = scan.nextLine();
        System.out.println("请输入昵称：");
        String nickname = scan.nextLine();
        System.out.println("请输入年龄：");
        int age = scan.nextInt();
        ps = connection.prepareStatement("INSERT INTO userinfo(username, password, nickname, age) VALUES (?, ?, ?, ?)");
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, nickname);
        ps.setInt(4, age);
        if (ps.executeUpdate() == 1) {
            System.out.println("成功");
        } else {
            System.out.println("?");
        }
    }
}
