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
import java.util.List;

public class FurnitureServlet extends BasicServlet {
    private FurnitureService furnitureService = new FurnitureServiceImpl();

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Furniture> furnitureList = furnitureService.queryFurnitures();
        // 将查询到的家具集合放入request域中
        request.setAttribute("furniture", furnitureList);
        // 请求转发
        request.getRequestDispatcher("/views/manage/furn_manage.jsp")
                .forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收需要添加的新产品信息
        // String name = request.getParameter("name");
        // String manufacturer = request.getParameter("manufacturer");
        // String price = request.getParameter("price");
        // String sales = request.getParameter("sales");
        // String stock = request.getParameter("stock");
        // String img = "default";

        // 新创建一个家具对象
        // furniture = new Furniture(null, name, manufacturer, new BigDecimal(price), new Integer(sales), new Integer(stock), img);

        // 对于之前版本的升级
        // 根据前端提供的信息封装成Furniture的java bean对象
        // 使用BeanUtils完成javabean对象的自动封装
        // 将request.getParameterMap()中的数据封装成Furniture对象
        Furniture furniture = DataUtils.copyParamToBean(request.getParameterMap(), new Furniture());
        furnitureService.addFurniture(furniture);
        // 添加成功
        // 为了防止表单的重复提交, 使用重定向功能
        response.sendRedirect(request.getContextPath()
                + "/manage/furnitureServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接收用户想要删除的家具商品
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        // 如果删除成功, 重新显示全部商品, 回到管理页面
        furnitureService.deleteFurnitureById(id);
        // response.sendRedirect(request.getContextPath() + "/manage/furnitureServlet?action=list");
        // 分页模式
        response.sendRedirect(request.getContextPath()
                + "/manage/furnitureServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    /**
     * 用于修改商品, 收到前端修改的请求后向后端获取商品
     * 转发到furn_update页面进行(展示)修改
     * @param request 管理员修改商品的请求
     * @param response
     */
    protected void listSingle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 接收用户想要修改的家具商品
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        // 查询商品
        Furniture furniture = furnitureService.queryFurnitureById(id);
        // 将furniture放入request域
        request.setAttribute("furniture", furniture);
        // 重定向 导航到新页面
        request.getRequestDispatcher("/views/manage/furn_update.jsp")
                .forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Furniture furniture = DataUtils.copyParamToBean(request.getParameterMap(), new Furniture());
        furnitureService.updateFurniture(furniture);
        // response.sendRedirect(request.getContextPath() + "/manage/furnitureServlet?action=list");

        // 分页模式
        response.sendRedirect(request.getContextPath()
        + "/manage/furnitureServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    /**
     * 处理分页请求
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取到要显示页面的页数
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        // 获取每页要显示多少条内容
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Furniture> page = furnitureService.page(pageNo, pageSize);
        System.out.println("page" + page);
        request.setAttribute("page", page);
        // 重定向 导航到新页面
        request.getRequestDispatcher("/views/manage/furn_manage.jsp")
                .forward(request, response);
    }
}
