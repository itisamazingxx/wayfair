package com.itisamazing.wayfair.entity;

import java.util.List;

/**
 * entity包, 提供java bean
 * 分页的数据模型, 包含分页的各种信息
 * @param <T> 分页模型对应的数据模型不确定(可能展示User, 商品, 或者订单etc...)
 */
public class Page<T> {

    public static final Integer PAGE_SIZE = 3;
    private Integer pageNo;
    private Integer totalRow; // 查询出的总记录数
    private Integer pageSize;
    private Integer totalPage; // totalRow/size
    private List<T> items; // 表示当前页要显示的数据
    private String url; // 用于分页导航

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
