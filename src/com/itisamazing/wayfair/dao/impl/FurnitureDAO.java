package com.itisamazing.wayfair.dao.impl;

import com.itisamazing.wayfair.entity.Furniture;

import java.util.List;

/**
 * 负责数据库产品细节管理的接口
 */
public interface FurnitureDAO {

    // 返回当前程序数据库管理下所有家具产品的集合
    // 后续再考虑分页
    public List<Furniture> queryAllFurnitures();

    // 添加一个新的家具
    public int addFurniture(Furniture furniture);

    // 删除一个已存在的家具
    public int deleteFurniture(int id);

    // 用于做修改家具时信息的回显
    public Furniture queryFurnitureById(int id);

    // 修改已存在家具商品的信息
    public int updateFurniture(Furniture furniture);

    public int getTotalRows();

    public List<Furniture> getPageItems(int begin, int pageSize);

    // 用于首页搜索
    public int getTotalRowsByName(String name);

    public List<Furniture> getPageItemsByName(int begin, int pageSize, String name);

}
