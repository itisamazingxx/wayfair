package com.itisamazing.wayfair.web;

import com.itisamazing.wayfair.entity.User;
import com.itisamazing.wayfair.service.UserService;
import com.itisamazing.wayfair.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BasicServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 检查用户登录是否成功, 并转到相应页面
     * @param request 从前端接收到的客户登录信息
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接收用户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 查询当前用户输入对象是否存在于数据库
        if (userService.isUserExist(username, password)) {
            // 将请求转发给对应页面
            request.getRequestDispatcher("/views/member/login_ok.jsp")
                    .forward(request, response);
        } else {
            // 把登录错误信息放到request域
            request.setAttribute("msg", "用户名或者密码错误");
            request.getRequestDispatcher("/views/member/login.jsp")
                    .forward(request, response);
        }
    }

    /**
     * 注册新用户(自增长id), 并转到相应页面
     * @param request 从前端接收到的客户注册信息
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接收用户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // 判断这个用户是否可用
        if (!userService.isUsernameExist(username)) {
            // 注册
            System.out.println("用户名" + username + "不存在");
        } else {
            System.out.println("用户名" + username + "已存在");
        }

        // 新创建一个user对象
        User user = new User(null, username, password, email);
        if (userService.registerUser(user)) {
            // 将请求转发给对应页面
            request.getRequestDispatcher("/views/member/register_ok.html")
                    .forward(request, response);
        } else {
            System.out.println("用户注册失败");
            request.getRequestDispatcher("/views/member/register_fail.html")
                    .forward(request, response);
        }
    }
}
