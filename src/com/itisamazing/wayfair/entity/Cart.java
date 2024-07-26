package com.itisamazing.wayfair.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

/**
 * entity包, 提供java bean
 * 购物车, 提供多个CartItem对象
 */
public class Cart {

    private HashMap<Integer, CartItem> items = new HashMap<>();
    // 初始化hashmap当购物车的数据结构
    // <家具id, cartItem(对应的家具对象)>

    // 添加家具到购物车
    public void addItem(CartItem cartItem) {
        // 先到购物车中查看当前想要添加的商品是否存在
        CartItem item = items.get(cartItem.getId());
        if (item == null) { // 还没出现过
            items.put(cartItem.getId(), cartItem);
        } else {
            // 购物车中已存在该商品, 增加数量
            item.setCount(item.getCount() + 1);
            // 修改总价
            item.setPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    /**
     * 返回购物车总价
     * @return
     */
    public BigDecimal getCartTotalPrice() {
        BigDecimal cartTotalPrice = new BigDecimal(0);
        Set<Integer> keys = items.keySet();
        for (Integer id : keys) {
            BigDecimal itemTotalPrice = ((CartItem) items.get(id)).getTotalPrice();
            cartTotalPrice = cartTotalPrice.add(itemTotalPrice);
        }
        return cartTotalPrice;
    }

    /**
     * 获取购物车内商品总数量
     */
    public int getTotalCount() {
        // 购物车商品总数
        int totalCount = 0;
        Set<Integer> keys = items.keySet();
        for (Integer id : keys) {
            totalCount += ((CartItem) items.get(id)).getCount();
        }
        return totalCount;
    }

    /**
     * 用于购物车商品数量的修改
     * @param id 待修改商品id
     * @param count 需要修改的商品数量
     */
    public void updateCount(int id, int count) {
        CartItem item = items.get(id);
        item.setCount(count);
        item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items.toString() +
                '}';
    }
}
