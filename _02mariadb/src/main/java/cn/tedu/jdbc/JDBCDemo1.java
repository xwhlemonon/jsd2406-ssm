package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tedu?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true", "root", "root");
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
