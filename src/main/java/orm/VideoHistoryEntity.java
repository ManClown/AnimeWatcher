package orm;

import java.util.Date;

public class VideoHistoryEntity {
        //观看时间
        private String watchTime;
        //视频号
        private String videoNumber;
        //记录ID
        private int id;




    //设置多对一关系
    private UsersEntity user;

    public String getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(String videoNumber) {
        this.videoNumber = videoNumber;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public String getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(String watchTime) {
        this.watchTime = watchTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
