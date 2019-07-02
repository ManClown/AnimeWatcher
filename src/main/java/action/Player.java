package action;

import com.opensymphony.xwork2.ActionSupport;

public class Player extends ActionSupport{

        private String playPath;

    public String getPlayPath() {
        return playPath;
    }

    public void setPlayPath(String playPath) {
        this.playPath = playPath;
    }

    public String play(){
        return SUCCESS;
    }
}
