package com.cachecats.data.shop.mapper;

import com.cachecats.data.shop.entity.ShopGroupInfoEntity;
import com.cachecats.domin.shop.model.ShopGroupInfoModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/25.
 */

public class ShopGroupInfoMapper implements Serializable {

    private GroupPackageMapper groupPackageMapper;

    @Inject
    public ShopGroupInfoMapper(GroupPackageMapper groupPackageMapper) {
        this.groupPackageMapper = groupPackageMapper;
    }

    public ShopGroupInfoModel toModel(ShopGroupInfoEntity entity) {
        ShopGroupInfoModel model = new ShopGroupInfoModel();
        model.setAutoRefund(entity.isAutoRefund);
        model.setBuyNotes(entity.buyNotes);
        model.setCurrentPrice(entity.currentPrice);
        model.setGroupId(entity.groupId);
        model.setGroupPackages(groupPackageMapper.toModels(entity.groupPackages));
        model.setLabel(entity.label);
        model.setName(entity.name);
        model.setNotes(entity.notes);
        model.setOriginalPrice(entity.originalPrice);
        model.setRefundAnyTime(entity.isRefundAnyTime);
        model.setServiceScore(entity.serviceScore);
        model.setSoldNum(entity.soldNum);
        model.setShopId(entity.shopId);
        return model;
    }

    public List<ShopGroupInfoModel> toModels(List<ShopGroupInfoEntity> entities) {
        List<ShopGroupInfoModel> models = new ArrayList<>();
        for (ShopGroupInfoEntity entity :
                entities) {
            models.add(toModel(entity));
        }
        return models;
    }

    public ShopGroupInfoEntity toEntity(ShopGroupInfoModel model) {
        ShopGroupInfoEntity entity = new ShopGroupInfoEntity();
        entity.groupPackages = groupPackageMapper.toEntities(model.getGroupPackages());
        entity.buyNotes = model.getBuyNotes();
        entity.currentPrice = model.getCurrentPrice();
        entity.groupId = model.getGroupId();
        entity.isAutoRefund = model.isAutoRefund();
        entity.isRefundAnyTime = model.isRefundAnyTime();
        entity.label = model.getLabel();
        entity.name = model.getName();
        entity.notes = model.getNotes();
        entity.originalPrice = model.getOriginalPrice();
        entity.serviceScore = model.getServiceScore();
        entity.shopId = model.getShopId();
        entity.soldNum = model.getSoldNum();
        return entity;
    }

    public List<ShopGroupInfoEntity> toEntities(List<ShopGroupInfoModel> models) {
        List<ShopGroupInfoEntity> entities = new ArrayList<>();
        if(models == null || models.isEmpty()){
            return Collections.emptyList();
        }

        for (ShopGroupInfoModel model : models) {
            entities.add(toEntity(model));
        }
        return entities;
    }
}
