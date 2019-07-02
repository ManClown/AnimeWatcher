package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import orm.UsersEntity;
import orm.Video;
import services.MediaService;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UploadVideoBean extends ActionSupport{


            private MediaService mediaS;
            private UserService userS;

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

            private String title;
            private String type;
            private String introduction;
            private File fileUpload[];
            ///private Fi fileUploadContentType = new ArrayList<String>();
            private String fileUploadFileName[];
            private String fileUploadContentType[];

    public String[] getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType[]) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public File[] getFileUpload() {
                return fileUpload;
            }

            public void setFileUpload(File fileUpload[]) {
                this.fileUpload = fileUpload;
            }

            public String[] getFileUploadFileName() {
                return fileUploadFileName;
            }

            public void setFileUploadFileName(String fileUploadFileName[]) {
                this.fileUploadFileName = fileUploadFileName;
            }

            public String upLoad(){
                Video video = new Video();
                video.setIntroduction(introduction);
                video.setType(type);
                video.setTitle(title);

                //String basePath = ServletActionContext.getServletContext().getRealPath("/upload");
                String videoPath = null;
                String srcPath = ServletActionContext.getServletContext().getRealPath("/upload");
                String destPath = ServletActionContext.getServletContext().getRealPath("/transfer");
                String mediaPicPath = ServletActionContext.getServletContext().getRealPath("/videoCut");
                File mediaPicpack = new File(mediaPicPath);
                if(!mediaPicpack.exists()){
                    mediaPicpack.mkdir();
                }
                File srcPack = new File(srcPath);
                if(!srcPack.exists()){
                    srcPack.mkdir();
                }
                File destPack = new File(destPath);
                if(!destPack.exists()){
                    destPack.mkdir();
                }
                HttpSession session = (HttpSession)ServletActionContext.getRequest().getSession(true);
                UsersEntity user = (UsersEntity) session.getAttribute("user");
                video.setUp(user);


                //先随机生成视频号
                String videoNumber = user.getUsername()+ System.currentTimeMillis();
                video.setVideoNumber(videoNumber);

                //获取文件格式
                //存储文件
                for(int i = 0; i < fileUploadFileName.length; ++i){

                        String fileName = fileUploadFileName[i];
                        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
                        byte []buffer = new byte[1024*1024*1024];
                        try(FileInputStream fis = new FileInputStream(fileUpload[i]);){
                           int length = -1;

                            if(suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png")||suffix.equalsIgnoreCase("gif")){
                                //上传文件为图片
                                File file =new File(mediaPicPath + File.separator + fileName);

                                FileOutputStream Pfos = new FileOutputStream(file);
                                video.setCover("videoCut/"+ fileName);
                                while((length = fis.read(buffer)) > 0){
                                    Pfos.write(buffer, 0, length);
                                }
                                Pfos.flush();
                                Pfos.close();
                            }else{
                                videoPath = srcPath + File.separator + fileName;
                                File file = new File(srcPath + File.separator + fileName);

                                FileOutputStream Vfos = new FileOutputStream(file);
                                //视频的播放地址dao层设置
                                //video.setLocation(destPath);
                                //srcPath = srcPath + File.separator + fileName;
                                //上传文件为视频
                                while((length = fis.read(buffer)) > 0){
                                    Vfos.write(buffer, 0, length);
                                }
                                Vfos.flush();
                                Vfos.close();
                            }
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                }
                mediaS.executeCodecs(videoPath, destPath, mediaPicPath, video);
                return SUCCESS;
            }
}
