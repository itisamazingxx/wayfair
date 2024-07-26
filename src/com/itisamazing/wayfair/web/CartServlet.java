package com.itisamazing.wayfair.web;

import com.itisamazing.wayfair.entity.Cart;
import com.itisamazing.wayfair.entity.CartItem;
import com.itisamazing.wayfair.entity.Furniture;
import com.itisamazing.wayfair.service.FurnitureService;
import com.itisamazing.wayfair.service.FurnitureServiceImpl;
import com.itisamazing.wayfair.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BasicServlet {

    private FurnitureService furnitureService = new FurnitureServiceImpl();

    /**
     * 添加家具信息到购物车
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 得到待添加家具id
        Integer id = DataUtils.parseInt(request.getParameter("id"), 0);
        // 获取到id对应的furniture对象
        Furniture furniture = furnitureService.queryFurnitureById(id);
        if (furniture == null) {
            return;
        }
        // 根据furniture家具对象构建cartItem对象
        CartItem item = new CartItem(furniture.getId(), furniture.getName(), furniture.getPrice(), 1, furniture.getPrice());

        // 从session中获取cart对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) { // 说明当前用户session没有购物车对象
            cart = new Cart();
            request.setAttribute("cart", cart);
        }
        // 向购物车添加商品
        cart.addItem(item);
        System.out.println(cart.toString());

        // 添加完毕后继续停留在原先页面
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }

    /**
     * 修改购物车数量
     */
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = DataUtils.parseInt(request.getParameter("id"),  0);
        int count = DataUtils.parseInt(request.getParameter("count"),  1);

        // 从session中获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            // 修改购物车数量
            cart.updateCount(id, count);
        }
        // 重新回到更新购物车的页面
        // 如果购物车是分页的, 需要回到请求更新的原页面
        response.sendRedirect(request.getHeader("Referer"));
    }

}
