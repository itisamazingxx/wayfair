package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.entity.User;
import com.itisamazing.wayfair.service.UserService;
import com.itisamazing.wayfair.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * 测试UserService中验证用户名, 保存用户等操作
 */
public class UserServiceImplTest {

    private UserService userService = new UserServiceImpl();
    private User user  = new User(null, "carl", "123", "carl111@gmail.com");

    @Test
    public void isUsernameExistTest() {
        boolean result = userService.isUsernameExist("jane");
        if (result == true) {
            System.out.println("用户已存在");
        } else {
            System.out.println("用户不存在");
        }

    }

    @Test
    public void registerUserTest() {
        boolean result = userService.registerUser(user);
        if (result == true) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
    }

    @Test
    public void isUserExist() {
        boolean result = userService.isUserExist("nihao123", "123456");
        if (result == true) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
