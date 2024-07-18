package com.itisamazing.wayfair.dao.impl;

import com.itisamazing.wayfair.entity.User;

/**
 * 负责数据库用户添加(注册)/查询(登录)等接口
 */
public interface UserDAO {

    // 提供一个通过用户名返回对应User的方法 (数据库查询)
    public User queryMemberByUsername(String username);
    // 提供一个保存User对象到数据库User表里的方法 (注册新用户)
    public int saveUser(User user);
    // 提供一个通过用户名和密码返回对应User的方法 (用户登录验证)
    public User queryMemberByUsernameAndPassword(String username, String password);

}
