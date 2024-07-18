package com.itisamazing.wayfair.dao.impl;

import com.itisamazing.wayfair.entity.User;

public class UserDAOImpl extends BasicDAO<User> implements UserDAO {

    /**
     * 通过用户名返回对应的用户
     * @param username 用户名
     * @return 返回用户对象, 如果不存在返回null
     */
    @Override
    public User queryMemberByUsername(String username) {
        String sql = "SELECT `id`, `user_name`, `password`, `email` FROM `user`\n" +
                " WHERE `user_name`=?";;
                // 查询单行用户结果
                return querySingle(sql, User.class, username);
    }

    /**
     * 保存一个新用户
     * @param user 传入需要存储的user对象
     * @return 返回数据库中受影响的行数, (返回-1就是失败)
     */
    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO `user` (`user_name`, `password`, `email`) VALUES\n" +
                " (?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    /**
     * 通过用户名和密码返回对应的用户
     * @param username 用户提供的用户名
     * @param password 用户提供的密码
     * @return 如果用户存在于数据库返回其对象, 否则返回null
     */
    @Override
    public User queryMemberByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`, `user_name`, `password`, `email` FROM `user`\n" +
                " WHERE `user_name` = ? AND `password` = ?";
        // 查询单行用户结果
        return querySingle(sql, User.class, username, password);
    }
}
