package com.itisamazing.wayfair.test;

import com.itisamazing.wayfair.dao.impl.FurnitureDAO;
import com.itisamazing.wayfair.dao.impl.FurnitureDAOimpl;
import com.itisamazing.wayfair.entity.Furniture;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class FurnitureDAOImplTest {
    private FurnitureDAO furnitureDAO = new FurnitureDAOimpl();

    @Test
    public void queryAllFurnituresTest() {
        List<Furniture> furnitureList = furnitureDAO.queryAllFurnitures();
        for (Furniture furniture : furnitureList) {
            System.out.println(furniture.toString());
        }
    }

    @Test
    public void addFurnitureTest() {
        Furniture furniture = new Furniture(null, "new dining table", "WoodWorks", new BigDecimal("399.99"), 20, 50, "images/dining_table.jpg");
        furnitureDAO.addFurniture(furniture);
    }

    @Test
    public void deleteFurnitureTest() {
        furnitureDAO.deleteFurniture(3);
    }

    @Test
    public void queryFurnitureById() {
        Furniture furniture = furnitureDAO.queryFurnitureById(12);
        System.out.println(furniture.toString());
    }

    @Test
    public void updateFurnitureTest() {
        Furniture furniture = new Furniture(13, "new dining table", "WoodWorks", new BigDecimal("399.99"), 20, 50, "images/dining_table.jpg");
        furniture.setManufacturer("nihaoma");
        furnitureDAO.updateFurniture(furniture);
    }

    @Test
    public void getTotalRowsTest() {
        int result = furnitureDAO.getTotalRows();
        System.out.println(result);
    }

    @Test
    public void getPageItemsTest() {
        List<Furniture> shownFurniture = furnitureDAO.getPageItems(0, 3);
        for (Furniture furniture : shownFurniture) {
            System.out.println(furniture.toString());
        }
    }

    @Test
    public void getTotalRowsByNameTest() {
        System.out.println(furnitureDAO.getTotalRowsByName("e"));
    }

    @Test
    public void getPageItemsByNameTest() {
        List<Furniture> furnitureList = furnitureDAO.getPageItemsByName(0, 2, "e");
        System.out.println(furnitureList);
    }
}
