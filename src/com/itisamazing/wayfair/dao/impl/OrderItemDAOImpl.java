package com.itisamazing.wayfair.dao.impl;

import com.itisamazing.wayfair.entity.OrderItem;

public class OrderItemDAOImpl extends BasicDAO<OrderItem> implements OrderItemDAO {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `order_item` (`name`, `price`, `count`, `total_price`, `order_id`)\n" +
                "VALUES (?, ?, ?, ?, ?)";
        return update(sql, orderItem.getName(), orderItem.getPrice(), orderItem.getCount(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
