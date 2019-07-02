package services.impl;

import dao.impl.UserDaoImpl;
import orm.CommentEntity;
import orm.UsersEntity;
import orm.Video;
import services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userD;

    public UserDaoImpl getUserD() {
        return userD;
    }

    public void setUserD(UserDaoImpl userD) {
        this.userD = userD;
    }

    /**
     * 查询用户信息
     * @param username  用户查询的数据
     * @return 返回用户实例
     */
    @Override
    public UsersEntity queryUser(String username) {
        return userD.queryUser(username);
    }

    /**
     * 添加用户信息
     * @param user 添加的用户
     * @return 返回是否添加成功
     */
    @Override
    public boolean addUser(UsersEntity user) {
        return userD.addUser(user);
    }

    /**
     * 修改用户密码
     * @param oldPassword  用户旧密码
     * @param newPassword  用户新密码
     * @return  返回用户密码是否修改成功
     */
    @Override
    public boolean updatePassword(String oldPassword, String newPassword, String username) {
        return userD.updatePassword(oldPassword, newPassword, username);
    }

    public boolean addVideo(Video video){
        return userD.addVideo(video);
    }

    @Override
    public boolean addComment(CommentEntity comment) {
        return userD.addComment(comment);
    }

    @Override
    public List<CommentEntity> queryCommentByVideoNumber(Video video) {
        return userD.queryCommentByVideoNumber(video);
    }
}
