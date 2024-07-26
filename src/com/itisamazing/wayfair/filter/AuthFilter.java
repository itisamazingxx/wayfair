package com.itisamazing.wayfair.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 用于权限验证的过滤器, 对指定的url进行验证
 * 对于需要登录才可以操作的请求, 返回登录页面
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
    }

    @Override
    public void destroy() {

    }
}
