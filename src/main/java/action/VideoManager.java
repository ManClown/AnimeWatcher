package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import orm.UsersEntity;
import orm.Video;
import services.MediaService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class VideoManager extends ActionSupport {
        private List<Video> list;
        private MediaService mediaS;

    public List<Video> getList() {
        return list;
    }

    public void setList(List<Video> list) {
        this.list = list;
    }

    public MediaService getMediaS() {
        return mediaS;
    }

    public void setMediaS(MediaService mediaS) {
        this.mediaS = mediaS;
    }

    public String queryVideoByup(){
        HttpSession session = ServletActionContext.getRequest().getSession(true);
        UsersEntity user  = (UsersEntity) session.getAttribute("user");
        this.setList(mediaS.queryVideoByUsername(user));
        return SUCCESS;
    }

    public String deleteVideo(){
        String videoNumber = ServletActionContext.getRequest().getParameter("videoNumber");
        if(mediaS.deleteVideo(videoNumber))
            return SUCCESS;
        return ERROR;
    }
}
