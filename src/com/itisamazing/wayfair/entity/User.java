package com.itisamazing.wayfair.entity;

/**
 * entity包, 提供java bean
 * 用户类
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;

    /**
     * 无参构造器是必须提供的
     * 底层需要使用到一个反射创建用户对象
     */
    public User() {
        // 创建反射的时候会使用到无参构造器
    }

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
