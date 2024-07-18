package com.itisamazing.wayfair.dao.impl;

import com.itisamazing.wayfair.entity.Admin;

/**
 * 负责管理员的接口
 */
public interface AdminDAO {

    // 负责管理员的登录验证
    // 在DAO层用于向数据库查询是否由该管理员存在
    public Admin queryAdminByUsernameAndPassword(String userName, String password);
}
