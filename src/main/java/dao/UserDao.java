package dao;

import orm.CommentEntity;
import orm.UsersEntity;
import orm.Video;

import java.util.List;

public interface UserDao {
        public UsersEntity queryUser(String username);
        public boolean addUser(UsersEntity user);
        public boolean updatePassword(String oldPassword, String newPassword, String username);
        public boolean addVideo(Video video);
        public boolean addComment(CommentEntity comment);
        public List<CommentEntity> queryCommentByVideoNumber(Video video);
}
