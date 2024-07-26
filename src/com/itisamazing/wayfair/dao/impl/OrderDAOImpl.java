package com.itisamazing.wayfair.dao.impl;

import com.itisamazing.wayfair.entity.Order;

public class OrderDAOImpl extends BasicDAO<Order> implements OrderDAO {

    /**
     * 订单业务: 将生成好的订单保存到数据库中
     * @param order 待保存订单
     * @return 成功返回1(受影响行数), otherwise返回0
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO `order` (`id`, `create_time`, `price`, `status`, `user_id`)" +
                "VALUES (?, ?, ?, ?, ?)";
        return update(sql, order.getId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

}
