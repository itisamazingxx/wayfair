package com.itisamazing.wayfair.service;

import com.itisamazing.wayfair.entity.Cart;
import com.itisamazing.wayfair.entity.Order;

public interface OrderService {

    // 生成订单
    // 需要知道购物车内商品内容, 当前账户隶属哪个会员
    public String saveOrder(Cart cart, int userId);
}
