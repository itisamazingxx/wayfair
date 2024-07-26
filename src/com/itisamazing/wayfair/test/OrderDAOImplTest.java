package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.dao.impl.OrderDAO;
import com.itisamazing.wayfair.dao.impl.OrderDAOImpl;
import com.itisamazing.wayfair.entity.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDAOImplTest {
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Test
    public void saveOrderTest() {
        Order order = new Order("sn10002", new Date(), new BigDecimal(100), 0, 2);
        System.out.println(orderDAO.saveOrder(order));
    }
}
