package com.cachecats.domin.shop.model;

import java.io.Serializable;

/**
 * Created by solo on 2018/1/25.
 * 团购套餐表对应的model
 */

public class GroupPackageModel implements Serializable {

    //团购套餐id
    private String id;
    //对应的团购id
    private String groupId;
    //对应的商铺id
    private String shopId;
    //团购名称
    private String title;
    //菜品名
    private String name;
    //数量
    private int count;
    //价格
    private float price;

    @Override
    public String toString() {
        return "GroupPackageModel{" +
                "id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
