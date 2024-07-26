package com.itisamazing.wayfair.service;

import com.itisamazing.wayfair.dao.impl.*;
import com.itisamazing.wayfair.entity.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private FurnitureDAO furnitureDAO = new FurnitureDAOimpl();

    /**
     * 订单生成service业务层
     * @param cart 会员所在购物车
     * @param userId 会员id
     * @return
     */
    @Override
    public String saveOrder(Cart cart, int userId) {
        // 将购物车内的数据以Order和OrderItem的形式保存到数据库中
        // 通过Cart对象构建一个对应的Order对象
        // 生成uuid -> 订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getCartTotalPrice(), 0, userId);
        // 保存order到数据库
        orderDAO.saveOrder(order);

        // 通过Cart对象, 遍历出OrderItem, 构建OrderItem对象, 并保存到对应数据库表
        // 购物车中有多少cartItem就要生成多少个orderItem
        HashMap<Integer, CartItem> items = cart.getItems();
        Set<Integer> keys = items.keySet();
        for (Integer id : keys) {
            CartItem item = items.get(id);
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getPrice(), item.getCount(),
                    item.getTotalPrice(), orderId);
            // 保存cartItem到orderItem
            orderItemDAO.saveOrderItem(orderItem);
            // 更新对应家具商品的库存, 销量
            Furniture furniture = furnitureDAO.queryFurnitureById(id);
            furniture.setSales(furniture.getSales() + item.getCount());
            furniture.setStock(furniture.getStock() - item.getCount());
            // 更新家具表中的家具商品信息
            furnitureDAO.updateFurniture(furniture);
        }
        // 清空购物车
        // cart.clean();
        return orderId;
    }
}
