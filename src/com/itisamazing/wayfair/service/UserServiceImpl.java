package com.itisamazing.wayfair.service;

import com.itisamazing.wayfair.dao.impl.UserDAO;
import com.itisamazing.wayfair.dao.impl.UserDAOImpl;
import com.itisamazing.wayfair.entity.User;

public class UserServiceImpl implements UserService {

    UserDAO userDAO = new UserDAOImpl();

    /**
     * 检查向数据库注册用户是否可以成功
     * @param user
     * @return 如果保存用户成功返回true
     */
    @Override
    public boolean registerUser(User user) {
        // 应该都是可以的, 因为id是自增长, 提前验证username是否有相同在数据库就可以
        return userDAO.saveUser(user) == 1 ? true : false;
    }


    /**
     * 判断当前用户名是否已存在于数据库
     * @param username
     * @return 如果存在返回true
     */
    @Override
    public boolean isUsernameExist(String username) {
       return userDAO.queryMemberByUsername(username) == null ? false : true;
    }

    /**
     * 判断当前试图登录的用户是否已存在于数据库
     * @param username 用户名 as string
     * @param password 密码 as string
     * @return 用户存在返回true, false otherwise
     */
    @Override
    public boolean isUserExist(String username, String password) {
        return userDAO.queryMemberByUsernameAndPassword(username, password) == null ? false : true;
    }
}
