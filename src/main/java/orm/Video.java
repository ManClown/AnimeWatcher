package orm;

import java.util.HashSet;
import java.util.Set;

public class Video {
       private String videoNumber;
       private String type;
       private String title;
       private String cover;
       private String introduction;
       private String location;
       //设置多对一关系
       private UsersEntity up;
       private Set<CommentEntity> comments=new HashSet<CommentEntity>();

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(String videoNumber) {
        this.videoNumber = videoNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UsersEntity getUp() {
        return up;
    }

    public void setUp(UsersEntity up) {
        this.up = up;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }
}
