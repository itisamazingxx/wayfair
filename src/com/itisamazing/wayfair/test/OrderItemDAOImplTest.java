package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.dao.impl.OrderItemDAO;
import com.itisamazing.wayfair.dao.impl.OrderItemDAOImpl;
import com.itisamazing.wayfair.entity.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OrderItemDAOImplTest {

    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void saveOrderItemTest() {
        OrderItem orderItem = new OrderItem(2, "table", new BigDecimal(100), 1, new BigDecimal(100), "sn10002");
        System.out.println(orderItemDAO.saveOrderItem(orderItem));
    }
}
