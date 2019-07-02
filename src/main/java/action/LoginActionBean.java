package action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import orm.UsersEntity;
import services.MediaService;
import services.UserService;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginActionBean extends ActionSupport {


    private String username;
    private String password;
    private UserService userS;



    public UserService getUserS() {
        return userS;
    }

    public void setUserS(UserService userS) {
        this.userS = userS;
    }

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

    public String doLogin() {
        String query_username = getUsername();
        UsersEntity user = userS.queryUser(query_username);
        if (user != null  && user.getPassword().equals(getPassword())){
            HttpSession session =  ServletActionContext.getRequest().getSession(true);
            UsersEntity sessionUser = (UsersEntity) session.getAttribute("user");
            if(sessionUser == null){
                session.setAttribute("user", user);
            }
            return SUCCESS;
        }
        else {
            try {
                ServletActionContext.getResponse().getWriter().write("alert('登录信息错误，请重新登录！')");
            }catch (IOException e){
                e.printStackTrace();
            }
            return "failure";
        }
    }

    public String doLogout(){
        HttpSession session = ServletActionContext.getRequest().getSession(true);
        session.removeAttribute("user");
        return SUCCESS;
    }

}
