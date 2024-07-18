package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.entity.Furniture;
import com.itisamazing.wayfair.entity.Page;
import com.itisamazing.wayfair.service.FurnitureService;
import com.itisamazing.wayfair.service.FurnitureServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class FurnitureServiceImplTest {

    private FurnitureService furnitureService = new FurnitureServiceImpl();
    private Furniture furniture = new Furniture(null, "Big Shark Closet", "WoodWorks", new BigDecimal("399.99"), 20, 50, "images/dining_table.jpg");

    @Test
    public void queryFurnituresTest() {
        List<Furniture> furnitureList = furnitureService.queryFurnitures();
        for (Furniture furniture : furnitureList) {
            System.out.println(furniture.toString());
        }
    }

    @Test
    public void addFurnitureTest() {
        boolean result = furnitureService.addFurniture(furniture);
        System.out.println(result);
    }

    @Test
    public void deleteFurnitureTest() {
        boolean result = furnitureService.deleteFurnitureById(4);
        System.out.println(result);
    }

    @Test
    public void queryFurnitureByIdTest() {
        Furniture furniture1 = furnitureService.queryFurnitureById(12);
        System.out.println(furniture1.getName());
    }

    @Test
    public void updateFurnitureTest() {
        furniture.setId(12);
        furniture.setManufacturer("heihei");
        furnitureService.updateFurniture(furniture);
    }

    @Test
    public void pageTest() {
        Page<Furniture> page = furnitureService.page(1, 3);
        List<Furniture> furnitureList = page.getItems();
        for (Furniture furniture : furnitureList) {
            System.out.println(furniture.toString());
        }
        System.out.println(page.getTotalRow());
        System.out.println(page.getTotalPage());
    }

    @Test
    public void pageByNameTest() {
        Page page = furnitureService.pageByName(1, 2, "e");
        System.out.println(page);
    }


}
