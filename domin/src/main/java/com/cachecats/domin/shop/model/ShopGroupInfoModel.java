package com.cachecats.domin.shop.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by solo on 2018/1/25.
 * 店铺的团购信息表对应的model
 */

public class ShopGroupInfoModel implements Serializable {

     //团购id
    private String groupId;

     //店铺id
    private String shopId;

    //团购名称
    private String name;

    //原价
    private float originalPrice;

    //现价
    private float currentPrice;

    //已售
    private int soldNum;

    //说明
    private String notes;

    //是否随时退
    private boolean isRefundAnyTime;

    //是否过期自动退
    private boolean isAutoRefund;

    //服务评分
    private float serviceScore;

    //标签
    private String label;

     //购买须知
    private String buyNotes;

    //团购套餐
    private List<GroupPackageModel> groupPackages;

    @Override
    public String toString() {
        return "ShopGroupInfoModel{" +
                "groupId='" + groupId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", name='" + name + '\'' +
                ", originalPrice=" + originalPrice +
                ", currentPrice=" + currentPrice +
                ", soldNum=" + soldNum +
                ", notes='" + notes + '\'' +
                ", isRefundAnyTime=" + isRefundAnyTime +
                ", isAutoRefund=" + isAutoRefund +
                ", serviceScore=" + serviceScore +
                ", label='" + label + '\'' +
                ", buyNotes='" + buyNotes + '\'' +
                ", groupPackages=" + groupPackages +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(int soldNum) {
        this.soldNum = soldNum;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isRefundAnyTime() {
        return isRefundAnyTime;
    }

    public void setRefundAnyTime(boolean refundAnyTime) {
        isRefundAnyTime = refundAnyTime;
    }

    public boolean isAutoRefund() {
        return isAutoRefund;
    }

    public void setAutoRefund(boolean autoRefund) {
        isAutoRefund = autoRefund;
    }

    public float getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(float serviceScore) {
        this.serviceScore = serviceScore;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBuyNotes() {
        return buyNotes;
    }

    public void setBuyNotes(String buyNotes) {
        this.buyNotes = buyNotes;
    }

    public List<GroupPackageModel> getGroupPackages() {
        return groupPackages;
    }

    public void setGroupPackages(List<GroupPackageModel> groupPackages) {
        this.groupPackages = groupPackages;
    }
}
