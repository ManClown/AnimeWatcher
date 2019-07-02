package dao.impl;

import dao.UserDao;
import org.hibernate.*;
import orm.CommentEntity;
import orm.UsersEntity;
import orm.Video;

import java.util.List;

public class UserDaoImpl implements UserDao{
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 查询用户信息
     * @param username 用户查询的数据
     * @return 返回查询用户
     */
    public UsersEntity queryUser(String username){
        Session session = sessionFactory.getCurrentSession();
        String hql = "from UsersEntity where username=?";
        Query query = session.createQuery(hql);
        query.setString(0,username);
        List<UsersEntity> user = query.list();
        if(user.size() == 0) return null;
        return user.get(0);
    }

    public boolean addUser(UsersEntity user){
        Session session = sessionFactory.getCurrentSession();

        session.save(user);

        return true;
    }

    /**
     * 修改用户密码
     * @param oldPassword  旧密码
     * @param newPassword  新密码
     * @return
     */
    @Override
    public boolean updatePassword(String oldPassword, String newPassword, String username) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "update UserEntity set password=? where password=? and username=?";
        int result = 0;
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery(sql);
        query.setString(0,oldPassword);
        query.setString(1,newPassword);
        query.setString(2,username);
        result = query.executeUpdate();
        transaction.commit();
        if(result != 0) return true;
        return false;
    }

    public boolean addVideo(Video video){
        Session session = sessionFactory.getCurrentSession();
        session.save(video);
        return true;
    }

    @Override
    public boolean addComment(CommentEntity comment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(comment);
        return true;
    }

    @Override
    public List<CommentEntity> queryCommentByVideoNumber(Video video) {
        List<CommentEntity> list = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from CommentEntity where video=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,video);
        list = query.list();
        return list;
    }
}
