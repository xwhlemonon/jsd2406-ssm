package cn.tedu._5springmvc.pojo.dto;

public class UserRegDTO {
    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegDTO{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
