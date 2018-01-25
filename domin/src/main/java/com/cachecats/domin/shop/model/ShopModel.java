package com.cachecats.domin.shop.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by solo on 2018/1/18.
 * 商店对应的 model
 */

public class ShopModel implements Serializable{

    private String id;
    private String name;
    private String logo;
    private String address;
    private String tel;
    private float serviceScore;
    private float perConsume;
    private String introduction;
    private String recommendDishes;
    private List<ShopGroupInfoModel> groupInfos;

    @Override
    public String toString() {
        return "ShopModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", serviceScore=" + serviceScore +
                ", perConsume=" + perConsume +
                ", introduction='" + introduction + '\'' +
                ", recommendDishes='" + recommendDishes + '\'' +
                ", groupInfos=" + groupInfos +
                '}';
    }

    public List<ShopGroupInfoModel> getGroupInfos() {
        return groupInfos;
    }

    public void setGroupInfos(List<ShopGroupInfoModel> groupInfos) {
        this.groupInfos = groupInfos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public float getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(float serviceScore) {
        this.serviceScore = serviceScore;
    }

    public float getPerConsume() {
        return perConsume;
    }

    public void setPerConsume(float perConsume) {
        this.perConsume = perConsume;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRecommendDishes() {
        return recommendDishes;
    }

    public void setRecommendDishes(String recommendDishes) {
        this.recommendDishes = recommendDishes;
    }
}
