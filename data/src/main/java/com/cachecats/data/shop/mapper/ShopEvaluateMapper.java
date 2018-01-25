package com.cachecats.data.shop.mapper;

import com.cachecats.data.shop.entity.ShopEvaluateEntity;
import com.cachecats.domin.shop.model.ShopEvaluateModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/25.
 * entity model 转换类
 */

public class ShopEvaluateMapper {

    @Inject
    public ShopEvaluateMapper() {
    }

    public ShopEvaluateModel toModel(ShopEvaluateEntity entity) {
        ShopEvaluateModel model = new ShopEvaluateModel();
        model.setEvaluateScore(entity.evaluateScore);
        model.setEvaluation(entity.evaluation);
        model.setGroupId(entity.groupId);
        model.setId(entity.id);
        model.setPerConsume(entity.perConsume);
        model.setPictures(entity.pictures);
        model.setRecommendDishes(entity.recommendDishes);
        model.setShopId(entity.shopId);
        model.setUserHeads(entity.userHeads);
        model.setUserId(entity.userId);
        model.setUserName(entity.userName);
        return model;
    }

    public List<ShopEvaluateModel> toModels(List<ShopEvaluateEntity> entities) {
        List<ShopEvaluateModel> models = new ArrayList<>();
        for (ShopEvaluateEntity entity : entities) {
            models.add(toModel(entity));
        }
        return models;
    }

    public ShopEvaluateEntity toEntity(ShopEvaluateModel model) {
        ShopEvaluateEntity entity = new ShopEvaluateEntity();
        entity.evaluateScore = model.getEvaluateScore();
        entity.evaluation = model.getEvaluation();
        entity.groupId = model.getGroupId();
        entity.id = model.getId();
        entity.perConsume = model.getPerConsume();
        entity.pictures = model.getPictures();
        entity.recommendDishes = model.getRecommendDishes();
        entity.shopId = model.getShopId();
        entity.userHeads = model.getUserHeads();
        entity.userId = model.getUserId();
        entity.userName = model.getUserName();
        return entity;
    }

    public List<ShopEvaluateEntity> toEntities(List<ShopEvaluateModel> models) {
        List<ShopEvaluateEntity> entities = new ArrayList<>();
        for (ShopEvaluateModel model : models) {
            entities.add(toEntity(model));
        }
        return entities;
    }
}
