package com.itisamazing.wayfair.web;

import com.itisamazing.wayfair.entity.Furniture;
import com.itisamazing.wayfair.entity.Page;
import com.itisamazing.wayfair.service.FurnitureService;
import com.itisamazing.wayfair.service.FurnitureServiceImpl;
import com.itisamazing.wayfair.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerFurnitureServlet extends BasicServlet {

    private FurnitureService furnitureService = new FurnitureServiceImpl();

    /**
     * 仍然是分页请求家具的api
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取到要显示页面的页数
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        // 获取每页要显示多少条内容
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Furniture> page = furnitureService.page(pageNo, pageSize);
        System.out.println(page.getPageNo());
        request.setAttribute("page", page);
        // 重定向 导航到新页面
        request.getRequestDispatcher("/views/customer/index.jsp")
                .forward(request, response);
    }

    /**
     * 处理客户端的搜索请求
     */
    protected void pageByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取到要显示页面的页数
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        // 获取每页要显示多少条内容
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 获取要搜索的家具名
        String name = request.getParameter("name");
        Page<Furniture> page = furnitureService.pageByName(pageNo, pageSize, name);
        request.setAttribute("page", page);
        // 重定向 导航到新页面
        request.getRequestDispatcher("/views/customer/index.jsp")
                .forward(request, response);
    }
}
