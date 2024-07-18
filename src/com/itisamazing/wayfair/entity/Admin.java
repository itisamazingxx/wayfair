package com.itisamazing.wayfair.entity;

/**
 * entity包, 提供java bean
 * 管理员类, 仅用于管理员登录
 */
public class Admin {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
