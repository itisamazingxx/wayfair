package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.dao.impl.UserDAOImpl;
import com.itisamazing.wayfair.entity.User;
import org.junit.jupiter.api.Test;

/**
 * 用来测试UserDAOImpl里向数据库的:
 * (1.) 查询用户操作
 * (2.) 保存用户
 */
public class UserDAOImplTest {

    private UserDAOImpl userDAO = new UserDAOImpl();
    private User user = new User(null, "louis", "123", "louis777@gmail.com");

    @Test
    public void queryMemberByUsernameTest() {
        if (userDAO.queryMemberByUsername("jane") == null) {
            System.out.println("该用户不存在");
        } else {
            System.out.println("该用户存在于数据库");
        }
    }

    @Test
    public void saveUserTest() {
        if (userDAO.saveUser(user) > 0) {
            System.out.println("保存用户成功");
        } else {
            System.out.println("用户已存在或信息输入错误");
        }
    }

    @Test
    public void queryMemberByUsernameAndPasswordTest() {
        User user = userDAO.queryMemberByUsernameAndPassword("nihao123", "123456");
        if (user != null) {
            System.out.println("用户存在数据库 可以登录");
        } else {
            System.out.println("信息输入错误或用户不存在");
        }
    }
}
