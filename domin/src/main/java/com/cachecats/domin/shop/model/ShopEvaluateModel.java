package com.cachecats.domin.shop.model;

import java.io.Serializable;

/**
 * Created by solo on 2018/1/25.
 * 商铺评价表对应的model
 */

public class ShopEvaluateModel implements Serializable{

    //评价id
    private String id;
    //用户id
    private String userId;
    //用户名
    private String userName;
    //用户头像
    private String userHeads;
    //商铺id
    private String shopId;
    //团购id
    private String groupId;
    //评价内容
    private String evaluation;
    //评分
    private float evaluateScore;
    //人均消费
    private float perConsume;
    //上传的图片地址
    private String pictures;
    //推荐菜
    private String recommendDishes;

    @Override
    public String toString() {
        return "ShopEvaluateModel{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userHeads='" + userHeads + '\'' +
                ", shopId='" + shopId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", evaluation='" + evaluation + '\'' +
                ", evaluateScore=" + evaluateScore +
                ", perConsume=" + perConsume +
                ", pictures='" + pictures + '\'' +
                ", recommendDishes='" + recommendDishes + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeads() {
        return userHeads;
    }

    public void setUserHeads(String userHeads) {
        this.userHeads = userHeads;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public float getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(float evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public float getPerConsume() {
        return perConsume;
    }

    public void setPerConsume(float perConsume) {
        this.perConsume = perConsume;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getRecommendDishes() {
        return recommendDishes;
    }

    public void setRecommendDishes(String recommendDishes) {
        this.recommendDishes = recommendDishes;
    }
}
