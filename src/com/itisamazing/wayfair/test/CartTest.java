package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.entity.Cart;
import com.itisamazing.wayfair.entity.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CartTest {

    private Cart cart = new Cart();
    private CartItem item = new CartItem(1, "MordernSofa", new BigDecimal(600), 1, new BigDecimal(600));

    @Test
    public void addItem() {
        cart.addItem(item);
        System.out.println(cart);
    }

}
