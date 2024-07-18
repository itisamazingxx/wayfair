package com.itisamazing.wayfair.entity;

import java.math.BigDecimal;

/**
 * entity包, 提供java bean
 * 家具类
 */
public class Furniture {

    private Integer id;
    private String name;
    private String manufacturer;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String img = "web/assets/images/product-image/default.jpg";

    public Furniture() {

    }

    public Furniture(Integer id, String name, String manufacturer, BigDecimal price, Integer sales, Integer stock, String img) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        if (!(img == null || "".equals(img))) {
            this.img = img;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Furniture {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img='" + img + '\'' +
                '}';
    }
}
