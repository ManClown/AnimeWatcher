package services.impl;

import dao.MediaDao;
import orm.UsersEntity;
import orm.Video;
import orm.VideoHistoryEntity;
import services.MediaService;

import java.util.List;

public class MediaServiceImpl implements MediaService{
    private MediaDao mediaDao;
    @Override
    public boolean executeCodecs(String srcFilePath, String codcFilePath, String mediaPicPath, Video video) {
        return mediaDao.executeCodecs(srcFilePath, codcFilePath, mediaPicPath, video);
    }

    public MediaDao getMediaDao() {
        return mediaDao;
    }

    public void setMediaDao(MediaDao mediaDao) {
        this.mediaDao = mediaDao;
    }

    public List<Video>  queryAllVideo(){
        return mediaDao.queryAllVideo();
    }

    public Video queryVideoByNumber(String videoNumber){
        return mediaDao.queryVideoByNumber(videoNumber);
    }

    public boolean addRecord(VideoHistoryEntity record){
        return mediaDao.addRecord(record);
    }

    public List<VideoHistoryEntity> queryVideoHistory(UsersEntity user){
        return mediaDao.queryVideoHistory(user);
    }

    public List<Video> queryVideoByType(String type){
        return mediaDao.queryVideoByType(type);
    }

    public List<Video> doSearch(String keyword){
        return mediaDao.doSearch(keyword);
    }

    @Override
    public List<Video> queryVideoByUsername(UsersEntity user) {
        return mediaDao.queryVideoByUsername(user);
    }

    @Override
    public boolean deleteVideo(String videoNumber) {
        mediaDao.deleteCommentByVideoNumber(mediaDao.queryVideoByNumber(videoNumber));
        mediaDao.deleteHistoryByVideoNumber(videoNumber);
        return mediaDao.deleleVideo(videoNumber);
    }
}
