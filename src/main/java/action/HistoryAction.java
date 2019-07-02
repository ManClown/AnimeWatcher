package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import orm.UsersEntity;
import orm.Video;
import orm.VideoHistoryEntity;
import services.MediaService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class HistoryAction extends ActionSupport {
            private List<Video> historylist;
            private List<Video> display;
            private int pageNum;
            private MediaService mediaS;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<Video> getDisplay() {
        return display;
    }

    public void setDisplay(List<Video> display) {
        this.display = display;
    }

    public List<Video> getHistorylist() {
        return historylist;
    }

    public void setHistorylist(List<Video> historylist) {
        this.historylist = historylist;
    }

    public MediaService getMediaS() {
        return mediaS;
    }

    public void setMediaS(MediaService mediaS) {
        this.mediaS = mediaS;
    }

    public String listHistory(){
        HttpSession session = ServletActionContext.getRequest().getSession(true);
        if(historylist == null){
            UsersEntity user = (UsersEntity) session.getAttribute("user");
            List<VideoHistoryEntity> historys = mediaS.queryVideoHistory(user);
            historylist = new ArrayList<Video>();
            for(VideoHistoryEntity historyEntity:historys){
                historylist.add(mediaS.queryVideoByNumber(historyEntity.getVideoNumber()));
            }
            setPageNum((historys.size()+19)/20);
        }
        if(display == null) setDisplay(new ArrayList<Video>());
        String pageStr = ServletActionContext.getRequest().getParameter("page");
        //默认页
        if(pageStr == null){
            int count = historylist.size() > 20 ? 20:historylist.size();
            if(display.size() != 0) display.clear();
            for(int i = 0; i < count; ++i){
                display.add(historylist.get(i));
            }
        }else {
            int page = Integer.parseInt(pageStr);
            int count = historylist.size() > page*20 ? page*20:historylist.size();
            if(display.size() != 0) display.clear();
            for(int i = 20*(page-1); i < count; ++i){
                display.add(historylist.get(i));
            }
        }
        return SUCCESS;
    }
}
