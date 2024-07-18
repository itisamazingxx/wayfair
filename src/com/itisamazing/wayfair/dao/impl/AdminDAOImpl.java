package com.itisamazing.wayfair.dao.impl;

import com.itisamazing.wayfair.entity.Admin;

public class AdminDAOImpl extends BasicDAO<Admin> implements AdminDAO {

    /**
     * 根据用户名密码查询管理员是否存在
     * @param userName 管理员提供的用户名
     * @param password 管理员提供的密码
     * @return 查询后的对象, 如果不存在则null
     */
    @Override
    public Admin queryAdminByUsernameAndPassword(String userName, String password) {
        String sql = "SELECT `id`, `user_name`, `password` FROM `admin`\n" +
                " WHERE `user_name` = ? AND `password` = ?";
        // 查询单行用户结果
        return querySingle(sql, Admin.class, userName, password);
    }
}
