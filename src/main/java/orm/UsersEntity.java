package orm;

import java.util.List;
import java.util.Set;

public class UsersEntity {
        //用户账号 邮箱 外键
        private String username;
        //用户昵称
        private String nickname;
        //用户密码
        private String password;




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
