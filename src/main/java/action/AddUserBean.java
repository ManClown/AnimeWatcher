package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import orm.UsersEntity;
import services.UserService;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddUserBean extends ActionSupport{

        private UsersEntity user;
       // private  String repassword;

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    /*
    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }*/

    private UserService userS;
    /*
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    */
    public UserService getUserS() {
        return userS;
    }

    public void setUserS(UserService userS) {
        this.userS = userS;
    }

    /**
     * 添加用户操作
     * @return 根据是否添加成功返回不同页面
     */
    public String addUser(){

        if(userS.queryUser(user.getUsername()) != null) {
            try {
                ServletActionContext.getResponse().getWriter().write("alert('用户已存在，注册失败！')");
            }catch (IOException e){
                e.printStackTrace();
            }
            return ERROR;
        }
        if(userS.addUser(user)){
            HttpSession session  = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("user", user);
            return SUCCESS;
        }else
            return ERROR;
    }

    /**
     * 转向注册jsp页面
     * @return
     */
    public String register(){
        return SUCCESS;
    }
}
