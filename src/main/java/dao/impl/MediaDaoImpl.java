package dao.impl;

import dao.MediaDao;
import dao.UserDao;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import orm.UsersEntity;
import orm.Video;
import orm.VideoHistoryEntity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MediaDaoImpl implements MediaDao{

    private UserDao useD;
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserDao getUseD() {
        return useD;
    }

    public void setUseD(UserDao useD) {
        this.useD = useD;
    }

    @Override
    public boolean executeCodecs(String srcFilePath, String codcFilePath,
                                 String mediaPicPath, Video video) {
        String basePath = System.getProperty("user.dir");
        File file = new File(codcFilePath);
        String mencoderPath = file.getParentFile().getParentFile().getAbsolutePath()
                + File.separator +  "classes"+File.separator+"tools"+
                File.separator+"mencoder.exe";
        String ffmpegPath = file.getParentFile().getParentFile().getAbsolutePath()
                + File.separator + "classes"+File.separator+"tools"+
                File.separator+"ffmpeg.exe";
        boolean mark =true;
        String tempPath = basePath + File.separator + "temp" + File.separator +
                String .valueOf(System.currentTimeMillis()) + ".avi";
        if(isConvertAVI(srcFilePath)){
            mark = this.convertAVI(mencoderPath, srcFilePath, tempPath);
            srcFilePath = tempPath;
        }
        if(isConvertFLV(srcFilePath) && mark){
            String serialName = String.valueOf(System.currentTimeMillis());
            String destPath = codcFilePath + File.separator + serialName + ".flv";
            video.setLocation("transfer/"+serialName+".flv");
            useD.addVideo(video);
            mark = this.convertFLV(ffmpegPath, srcFilePath, destPath);
        }else{
            System.out.println("该视频格式无法转换");
        }
        this.deleteFile(tempPath);
        this.deleteFile(srcFilePath);
        return mark;
    }

    public boolean convertFLV(String ffmpegPath, String srcFilePath, String codcFilePath){
        File file = new File(ffmpegPath);
        File srcFile = new File(srcFilePath);
        if(file.exists()){
            System.out.println("转换工具存在");
        }
        if(srcFile.exists()){
            System.out.println("源视频存在");
        }
        //创建一个List集合来保存转换视频文件为flv格式的命令
        List<String> convert = new ArrayList<>();
        convert.add(ffmpegPath); //添加转换工具路径
        convert.add("-i");  //添加参数"-i", 改参数指定要转换的文件
        convert.add(srcFilePath); //添加要转换格式的视频文件的路径
        convert.add("-ab");  //设置音频码率
        convert.add("128");
        convert.add("-ac");  //设置声道数
        convert.add("2");
        convert.add("-qscale");
        convert.add("6");
        convert.add("-ar");   //设置声音的采样频率
        convert.add("22050");
        convert.add("-r");  //设置帧频
        convert.add("29.97");
        convert.add("-b");
        convert.add("5942.13");
        convert.add("-s");
        convert.add("1280x720");
        convert.add("-y");  //添加参数"-y"，该参数指定要覆盖已存在的文件
        convert.add(codcFilePath);

        boolean mark = true;
        try{
            Process proc = new ProcessBuilder(convert).redirectErrorStream(true).start();
            BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while((line = stdout.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            mark = false;
            System.out.println(e);
            e.printStackTrace();
        }
        return mark;
    }

    public boolean convertAVI(String mencoderPath, String srcFilePath, String codcFilePath){
            List<String> commend = new ArrayList<>();
            commend.add(mencoderPath);
            commend.add(srcFilePath);
            commend.add("-oac");
            commend.add("lavc");
            commend.add("-lavcopts");
            commend.add("acode=mp3:abitrate=64");
            commend.add("-ovc");
            commend.add("xvid");
            commend.add("-xvideoncopts");
            commend.add("bitrate=600");
            commend.add("-of");
            commend.add("avi");
            commend.add("-o");
            commend.add(codcFilePath);
            try{
                ProcessBuilder  builder = new ProcessBuilder();
                builder.command(commend);
                builder.redirectErrorStream(true); //后续子进程错误输出与标准输出合并
                Process p = builder.start();
                p.getInputStream();
                //后续进程等待Mencoder进程转换结束后才可进行
                p.waitFor();
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
    }

    @Override
    public void deleteFile(String tempFile) {
        File file = new File(tempFile);
        if(file.exists()){
            file.delete();
        }
    }

    @Override
    public boolean isConvertFLV(String file) {
        boolean result = false;
        String ext = file.substring(file.lastIndexOf(".")+1, file.length()).toLowerCase();
        //ffmpeg能解析的格式:(asx, asf, mpg, wmv, 3gp, mp4, mov, avi, flv)
        //解析视频文件格式
        if(ext.equals("avi")){
            result = true;
        }else if(ext.equals("mpg")){
            result = true;
        }else if(ext.equals("wmv")) {
            result = true;
        }else if(ext.equals("3gp")){
            result = true;
        }else if(ext.equals("mov")){
            result = true;
        }else if(ext.equals("mp4")){
            result = true;
        }else if(ext.equals("asf")){
            result = true;
        }else if(ext.equals("asx")){
            result = true;
        }else if(ext.equals("flv")){
            result = true;
        }
        return result;
    }

    @Override
    public boolean isConvertAVI(String file) {
        boolean result = false;
        String ext = file.substring(file.lastIndexOf(".")+1,
                        file.length()).toLowerCase();
        //ffmpeg 无法解析的文件格式(wmv9, rm, rmvb)
        //可以先用别的工具(mencoder)转换为AVI格式
        if(ext.equals("wmb9")){
            result = true;
        }else if(ext.equals("rm")){
            result = true;
        }else if(ext.equals("rmvb")){
            result = true;
        }
        return result;
    }

    @Override
    public List<Video> queryAllVideo(){
        List<Video> list = null;
        Session session = sessionFactory.getCurrentSession();
        String hql  = "from Video";
        Query query = session.createQuery(hql);
        list = query.list();
        return list;
    }

    public Video queryVideoByNumber(String videoNumber){
        List<Video> list = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Video where videoNumber=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,videoNumber);
        list = query.list();
        return list.get(0);
    }

    public boolean addRecord(VideoHistoryEntity record){
        Session session  = sessionFactory.getCurrentSession();
        session.save(record);
        return true;
    }

    public List<VideoHistoryEntity> queryVideoHistory(UsersEntity user){
        List<VideoHistoryEntity> list = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from VideoHistoryEntity where user=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, user);
        list = query.list();
        return list;
    }

    public List<Video> queryVideoByType(String type){
        List<Video> list = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Video where type=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,type);
        list = query.list();
        return list;
    }

    public List<Video> doSearch(String keyword){
        List<Video> result = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Video where title like :title or introduction like :intro";
        Query query = session.createQuery(hql);
        query.setString("title","%"+keyword+"%");
        query.setString("intro","%"+keyword+"%");
        result = query.list();
        return result;
    }

    @Override
    public List<Video> queryVideoByUsername(UsersEntity user) {
        List<Video> list = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Video where up=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,user);
        list = query.list();
        return list;
    }

    @Override
    public boolean deleleVideo(String videoNumber) {
        Video video = queryVideoByNumber(videoNumber);
        String root = ServletActionContext.getServletContext().getRealPath("/");
        String deleteCover = root+video.getCover();
        String deleteLocation = root+video.getLocation();
        File coverFile = new File(deleteCover);
        File locationFile = new File(deleteLocation);
        coverFile.delete();
        locationFile.delete();
        String hql = "delete from Video where videoNumber=?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, videoNumber);
        query.executeUpdate();
        return true;
    }

    public boolean deleteCommentByVideoNumber(Video video){
        String hql = "delete from CommentEntity where video=?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,video);
        query.executeUpdate();
        return true;
    }

    public boolean deleteHistoryByVideoNumber(String videoNumber){
        String hql = "delete from VideoHistoryEntity where videoNumber=?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,videoNumber);
        query.executeUpdate();
        return true;
    }
}
