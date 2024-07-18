package com.itisamazing.wayfair.service;

import com.itisamazing.wayfair.dao.impl.AdminDAO;
import com.itisamazing.wayfair.dao.impl.AdminDAOImpl;

public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO = new AdminDAOImpl();

    /**
     * 管理员登录
     * @param userName
     * @param password
     * @return 管理员存在返回true
     */
    @Override
    public boolean isAdminExist(String userName, String password) {
        return adminDAO.queryAdminByUsernameAndPassword(userName, password) == null ? false : true;
    }
}
