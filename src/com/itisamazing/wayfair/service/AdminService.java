package com.itisamazing.wayfair.service;

public interface AdminService {

    // 管理员登录
    public boolean isAdminExist(String userName, String password);
}
