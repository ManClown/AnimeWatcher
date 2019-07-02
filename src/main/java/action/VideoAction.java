package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import orm.CommentEntity;
import orm.UsersEntity;
import orm.Video;
import orm.VideoHistoryEntity;
import services.MediaService;
import services.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoAction extends ActionSupport {
    private List<Video>  videoList;
    private List<Video>  display;
    private List<CommentEntity> commentList;
    private int pageNum;
    private MediaService mediaS;
    private UserService userS;
    private Video video;
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }

    public List<Video> getDisplay() {
        return display;
    }

    public void setDisplay(List<Video> display) {
        this.display = display;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public MediaService getMediaS() {
        return mediaS;
    }

    public void setMediaS(MediaService mediaS) {
        this.mediaS = mediaS;
    }

    public UserService getUserS() {
        return userS;
    }

    public void setUserS(UserService userS) {
        this.userS = userS;
    }

    public String queryAllVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryAllVideo());
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }
    public String queryAdventureVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Adventure"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryBooldVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Boold"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryCampusVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Campus"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryGameVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Game"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryHaremVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Harem"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryMagicVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Magic"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryParentkidVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Parentkid"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryResoningVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Resoning"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryRomanticVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Romantic"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String querySportsVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Sports"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryWarVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("War"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String queryYouthVideo(){
        if(videoList == null) {
            this.setVideoList(mediaS.queryVideoByType("Youth"));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

    public String doPlayer(){
        String videoNumber = ServletActionContext.getRequest().getParameter("videoNumber");
        Video video = mediaS.queryVideoByNumber(videoNumber);
        setVideo(video);
        HttpSession session = ServletActionContext.getRequest().getSession(true);
        UsersEntity user = (UsersEntity) session.getAttribute("user");
        if(user != null) {
            List<VideoHistoryEntity> records = mediaS.queryVideoHistory(user);
            boolean isExisted = false;
            for (VideoHistoryEntity history : records) {
                if (history.getVideoNumber().equals(videoNumber)) {
                    isExisted = true;
                    break;
                }
            }
            if (!isExisted) {
                VideoHistoryEntity record = new VideoHistoryEntity();
                record.setUser(user);
                record.setVideoNumber(video.getVideoNumber());
                Date now = new Date();
                record.setWatchTime(now.toString());
                mediaS.addRecord(record);
            }
        }
        setCommentList(userS.queryCommentByVideoNumber(video));
        return SUCCESS;
    }

    /**
     * 关键字查询视频
     * @return
     */
    public String queryKeywordVideo(){
        String keyword = ServletActionContext.getRequest().getParameter("keyword");
        if(videoList == null) {
            this.setVideoList(mediaS.doSearch(keyword));
            this.setPageNum((videoList.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());

        String pageStr = ServletActionContext.getRequest().getParameter("page");

        if(pageStr == null){
            int count = videoList.size() > 20 ? 20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(videoList.get(i));
            }
        }else{
            int page = Integer.parseInt(pageStr);
            int count = videoList.size() > page*20 ? page*20:videoList.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(videoList.get(i));
            }
        }
        return SUCCESS;
    }

}
