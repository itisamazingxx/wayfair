package com.itisamazing.wayfair.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * entity包, 提供java bean
 * 订单对象
 */
public class Order {

    private String id;
    private Date createTime; // java.util.Date
    private BigDecimal price;
    private Integer status;
    private Integer userId;

    public Order() {
    }

    public Order(String id, Date createTime, BigDecimal price, Integer status, Integer userId) {
        this.id = id;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

