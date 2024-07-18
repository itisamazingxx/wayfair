package com.itisamazing.wayfair.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 用来接收用户请求, 调用service
 */
public class BasicServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("当前action = " + action);
        // 使用反射获取到当前对象的方法
        try {
            // this指发起请求的Servlet (如果是用户注册登录, method就是userServlet)
            // 该方法对象在实际运行中是根据用户请求变化的
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 使用方法对象, 进行反射调用
            // 调用的是相应Servlet下的方法, method需与Servlet下方法名相同
            method.invoke(this, request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doPost(httpServletRequest, httpServletResponse);
    }
}
