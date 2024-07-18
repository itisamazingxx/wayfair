package com.itisamazing.wayfair.service;

import com.itisamazing.wayfair.entity.User;

/**
 * 管理用户注册登录的业务逻辑
 */
public interface UserService {

    // 注册用户
    public boolean registerUser(User user);
    // 判断用户名是否存在
    public boolean  isUsernameExist(String username);
    // 判断用户名&密码是否存在
    public boolean isUserExist(String username, String password);
}
