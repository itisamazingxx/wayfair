package com.itisamazing.wayfair.web;

import com.itisamazing.wayfair.service.AdminService;
import com.itisamazing.wayfair.service.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来接收跟Admin bean相关的请求, 并调用相应servlet
 */
public class AdminServlet extends BasicServlet {

    private AdminService adminService = new AdminServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收管理员登录信息
        String adminName = request.getParameter("name");
        String password = request.getParameter("password");

        // 查询当前管理员是否存在
        if (adminService.isAdminExist(adminName, password)) {
            // 将请求转发给对应页面
            request.getRequestDispatcher("/views/manage/manage_menu.jsp")
                    .forward(request, response);
        } else {
            // 把登录错误信息放到request域
            request.setAttribute("msg", "用户名或者密码错误");
            request.getRequestDispatcher("/views/manage/manage_login.jsp")
                    .forward(request, response);
        }
    }
}
