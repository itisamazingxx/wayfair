package com.itisamazing.wayfair.service;

import com.itisamazing.wayfair.entity.Furniture;
import com.itisamazing.wayfair.entity.Page;

import java.util.List;

public interface FurnitureService {

    // 返回家具信息
    public List<Furniture> queryFurnitures();

    // 添加新家具
    public boolean addFurniture(Furniture furniture);

    // 删除家具
    public boolean deleteFurnitureById(int id);

    // 显示单个家具
    public Furniture queryFurnitureById(int id);

    public boolean updateFurniture(Furniture furniture);

    // furnitureService层需要完成整个page的业务逻辑
    // 需要根据前端用户输入的显示请求(要求访问第几页), 返回对应的page实体
    public Page<Furniture> page(int pageNo, int pageSize);

    public Page<Furniture> pageByName(int pageNo, int pageSize, String name);
}
