package cn.tedu.spring.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private String url;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    @Value("jdbc:mysql://localhost:3306/tedu")
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    @Value("root")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Value("root")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDao{" + "url='" + url + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
