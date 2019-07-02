package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import orm.CommentEntity;
import orm.UsersEntity;
import services.MediaService;
import services.UserService;

public class CommentBean extends ActionSupport {
        private String videoNumber;
        private String comment;

        private UserService userS;
        private MediaService mediaS;

    public UserService getUserS() {
        return userS;
    }

    public void setUserS(UserService userS) {
        this.userS = userS;
    }

    public MediaService getMediaS() {
        return mediaS;
    }

    public void setMediaS(MediaService mediaS) {
        this.mediaS = mediaS;
    }

    public String getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(String videoNumber) {
        this.videoNumber = videoNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String comment(){
        ServletActionContext.getRequest().setAttribute("videoNumber", videoNumber);
        UsersEntity user = (UsersEntity) ServletActionContext.getRequest().getSession(true).getAttribute("user");
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(comment);
        commentEntity.setVideo(mediaS.queryVideoByNumber(videoNumber));
        commentEntity.setUserName(user.getUsername());
        userS.addComment(commentEntity);
        return SUCCESS;
    }
}
