package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo3 {
    public JDBCDemo3() throws ClassNotFoundException, SQLException {
        Connection connection = JDBCSuper.getConnection();
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = scanner.nextLine();
        String sql = "DELETE FROM userinfo WHERE userinfo.username = '" + userName + "'";
        if (statement.executeUpdate(sql) > 0) {
            System.out.println("删除成功···");
        } else {
            System.out.println("该用户不存在···");
        }
    }

    public static void main(String[] args) {
        try {
            new JDBCDemo3();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
