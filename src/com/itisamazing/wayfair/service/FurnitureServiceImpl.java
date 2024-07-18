package com.itisamazing.wayfair.service;

import com.itisamazing.wayfair.dao.impl.FurnitureDAO;
import com.itisamazing.wayfair.dao.impl.FurnitureDAOimpl;
import com.itisamazing.wayfair.entity.Furniture;
import com.itisamazing.wayfair.entity.Page;

import java.util.List;

public class FurnitureServiceImpl implements FurnitureService {

    private FurnitureDAO furnitureDAO = new FurnitureDAOimpl();

    /**
     * 查询所有家具信息
     * @return 返回所有家具信息的list形式
     */
    @Override
    public List<Furniture> queryFurnitures() {
        List<Furniture> furnitureList = furnitureDAO.queryAllFurnitures();
        return furnitureList;
    }

    /**
     * 添加新家具
     * @return 添加成功返回true, false otherwise
     */
    @Override
    public boolean addFurniture(Furniture furniture) {
       return furnitureDAO.addFurniture(furniture) == 1 ? true : false;
    }

    /**
     * 删除家具
     * @return 删除成功返回true, false otherwise
     */
    @Override
    public boolean deleteFurnitureById(int id) {
        return furnitureDAO.deleteFurniture(id) == 1 ? true : false;
    }

    @Override
    public Furniture queryFurnitureById(int id) {
        return furnitureDAO.queryFurnitureById(id);
    }

    @Override
    public boolean updateFurniture(Furniture furniture) {
        return furnitureDAO.updateFurniture(furniture) == 1 ? true : false;
    }

    @Override
    public Page<Furniture> page(int pageNo, int pageSize) {
        // 先创建一个page对象, 根据实际情况填充属性
        Page<Furniture> objPage = new Page<>();
        objPage.setPageNo(pageNo); // 参数传入
        objPage.setPageSize(pageSize);
        int totalRows = furnitureDAO.getTotalRows();
        objPage.setTotalRow(totalRows);
        int totalPage = objPage.getTotalRow() / pageSize;
        if (totalRows % pageSize > 0) {
            totalPage += 1;
        }
        objPage.setTotalPage(totalPage);
        int begin = (pageNo - 1) * pageSize;
        List<Furniture> items = furnitureDAO.getPageItems(begin, pageSize);
        objPage.setItems(items);
        return objPage;
    }

    @Override
    public Page<Furniture> pageByName(int pageNo, int pageSize, String name) {
        Page<Furniture> objPage = new Page<>();
        objPage.setPageNo(pageNo); // 参数传入
        objPage.setPageSize(pageSize);
        int totalRows = furnitureDAO.getTotalRowsByName(name);
        objPage.setTotalRow(totalRows);
        int totalPage = objPage.getTotalRow() / pageSize;
        if (totalRows % pageSize > 0) {
            totalPage += 1;
        }
        objPage.setTotalPage(totalPage);
        int begin = (pageNo - 1) * pageSize;
        List<Furniture> items = furnitureDAO.getPageItemsByName(begin, pageSize, name);
        objPage.setItems(items);
        return objPage;
    }


}
