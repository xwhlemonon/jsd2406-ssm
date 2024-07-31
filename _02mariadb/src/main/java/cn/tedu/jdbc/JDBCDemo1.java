package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String pass = scanner.nextLine();
        String nick = scanner.nextLine();
        Integer age = scanner.nextInt();
        String sql = "INSERT INTO tedu.userinfo(username, password, nickname, age) " + "VALUES ('" + name + "', '" + pass + "', '" + nick + "', " + age + ")";
        System.out.println(statement.executeUpdate(sql));
        connection.close();
    }
}
