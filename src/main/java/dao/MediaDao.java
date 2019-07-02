package dao;

import orm.UsersEntity;
import orm.Video;
import orm.VideoHistoryEntity;

import java.util.List;

public interface MediaDao {
    /**
     * 视频转码
     * @param srcFilePath  指定要转换格式的文件，以及要截图的文件
     * @param codcFilePath 格式转换之后的文件保存路径
     * @param mediaPicPath 截图保存路径
     * @return
     */
    public boolean executeCodecs(String srcFilePath, String codcFilePath, String mediaPicPath, Video video);

    /**
     * 可转换的FLV视频文件
     * @param file
     * @return
     */
    public boolean isConvertFLV(String file);

    /**
     * 可转换的AVI视频文件
     * @param file
     * @return
     */
    public boolean isConvertAVI(String file);

    /**
     * 删除中间转换视频文件
     * @param tempFile
     */
    public void deleteFile(String tempFile);

    /**
     * 查询所有视频文件
     * @return
     */
    public List<Video> queryAllVideo();

    /**
     * 根据视频号查询视频文件
     * @param videoNumber
     * @return
     */
    public Video queryVideoByNumber(String videoNumber);

    public boolean addRecord(VideoHistoryEntity record);

    public List<VideoHistoryEntity> queryVideoHistory(UsersEntity user);

    public List<Video> queryVideoByType(String type);

    public List<Video> doSearch(String keyword);

    public List<Video> queryVideoByUsername(UsersEntity user);

    public boolean deleleVideo(String videoNumber);

    public boolean deleteCommentByVideoNumber(Video video);

    public boolean deleteHistoryByVideoNumber(String videoNumber);
}
