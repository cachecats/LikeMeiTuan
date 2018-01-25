package com.cachecats.data.shop.mapper;

import com.cachecats.data.shop.entity.ShopEntity;
import com.cachecats.domin.shop.model.ShopModel;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/22.
 * 将 entity 转换为 model 的转换类
 */

public class ShopMapper {

    private ShopGroupInfoMapper shopGroupInfoMapper;

    @Inject
    public ShopMapper(ShopGroupInfoMapper shopGroupInfoMapper) {
        this.shopGroupInfoMapper = shopGroupInfoMapper;
    }

    public List<ShopModel>toModels(List<ShopEntity> entities){
        List<ShopModel> models = new ArrayList<>();
        for (ShopEntity entity : entities) {
            models.add(toModel(entity));
        }
        return models;
    }

    public ShopModel toModel(ShopEntity entity){
        ShopModel model = new ShopModel();
        model.setAddress(entity.address);
        model.setId(entity.id);
        model.setIntroduction(entity.introduction);
        model.setLogo(entity.logo);
        model.setName(entity.name);
        model.setPerConsume(entity.perConsume);
        model.setRecommendDishes(entity.recommendDishes);
        model.setServiceScore(entity.serviceScore);
        model.setTel(entity.tel);
        model.setGroupInfos(shopGroupInfoMapper.toModels(entity.getGroupInfos()));
        return model;
    }

    public ShopEntity toEntity(ShopModel model){
        ShopEntity entity = new ShopEntity();
        entity.address = model.getAddress();
        entity.id = model.getId();
        entity.introduction = model.getIntroduction();
        entity.logo = model.getLogo();
        entity.name = model.getName();
        entity.perConsume = model.getPerConsume();
        entity.recommendDishes = model.getRecommendDishes();
        entity.serviceScore = model.getServiceScore();
        entity.tel = model.getTel();
        entity.groupInfos = shopGroupInfoMapper.toEntities(model.getGroupInfos());
        return entity;
    }

    public List<ShopEntity> toEntities(List<ShopModel> models){
        List<ShopEntity> entities = new ArrayList<>();
        for (ShopModel model : models) {
            entities.add(toEntity(model));
        }
        return entities;
    }
}
