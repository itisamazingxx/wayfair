package com.itisamazing.wayfair.dao.impl;

import com.itisamazing.wayfair.entity.Furniture;

import java.util.List;

public class FurnitureDAOimpl extends BasicDAO<Furniture> implements FurnitureDAO {

    /**
     * 显示所有家具信息
     * @return 返回当前程序数据库管理下所有家具产品的集合
     */
    @Override
    public List<Furniture> queryAllFurnitures() {
        String sql = "SELECT `id`, `name`, `manufacturer`, `price`, `sales`, `stock`, `img`\n" +
                "FROM `furniture`";
        // 查询单行用户结果
        return queryMulti(sql, Furniture.class);
    }

    /**
     * 添加一个新的家具
     * @return 返回受影响的行数(检查是否添加成功), 返回1添加成功
     */
    @Override
    public int addFurniture(Furniture furniture) {
        String sql = "INSERT INTO `furniture` (`name`, `manufacturer`, `price`, `sales`, `stock`, `img`) VALUES\n" +
                " (?, ?, ?, ?, ?, ?)";
        return update(sql, furniture.getName(), furniture.getManufacturer(), furniture.getPrice(), furniture.getSales()
        , furniture.getStock(), furniture.getImg());
    }

    /**
     * 从数据库删除一个家具
     * @return 返回受影响的行数, 也就是被删除的行数
     */
    @Override
    public int deleteFurniture(int id) {
        String sql = "DELETE FROM `furniture` WHERE `id` = ?";
        return update(sql, id);
    }

    @Override
    public Furniture queryFurnitureById(int id) {
        String sql = "SELECT `id`, `name`, `manufacturer`, `price`, `sales`, `stock`, `img`\n" +
                "FROM `furniture` WHERE id = ?";
        return querySingle(sql, Furniture.class, id);
    }

    /**
     * 向数据库更新前端请求的商品信息
     * @param furniture
     * @return
     */
    @Override
    public int updateFurniture(Furniture furniture) {
        String sql = "UPDATE furniture "
                + "SET name = ?, manufacturer = ?, price = ?, "
                + "sales = ?, stock = ?, img = ? "
                + "WHERE id = ?";
        return update(sql, furniture.getName(), furniture.getManufacturer(), furniture.getPrice(), furniture.getSales(), furniture.getStock()
        , furniture.getImg(), furniture.getId());
    }

    @Override
    public int getTotalRows() {
        String sql = "SELECT COUNT(*) FROM `furniture`";
        return ((Number) queryScalar(sql)).intValue();
    }

    /**
     * 获取当前页所需要的家具数据
     * @param begin 表示从第几条记录开始获取 index from 0
     * @param pageSize 表示取出多少条记录
     * @return
     */
    @Override
    public List<Furniture> getPageItems(int begin, int pageSize) {
        String sql = "SELECT `id`, `name`, `manufacturer`, `price`, `sales`, `stock`, `img` " +
                "FROM `furniture` LIMIT ?, ?";
        return queryMulti(sql, Furniture.class, begin, pageSize);
    }

    @Override
    public int getTotalRowsByName(String name) {
        // 模糊查询, 返回满足关键字的所有条数
        String sql = "SELECT count(*) FROM `furniture` WHERE `name` LIKE ?";
        return ((Number) queryScalar(sql, "%" + name + "%")).intValue();
    }

    @Override
    public List<Furniture> getPageItemsByName(int begin, int pageSize, String name) {
        String sql = "SELECT `id`, `name`, `manufacturer`, `price`, `sales`, `stock`, `img` " +
                "FROM `furniture` WHERE `name` LIKE ? LIMIT ?, ?";
        return queryMulti(sql, Furniture.class, "%" + name + "%", begin, pageSize);
    }
}
