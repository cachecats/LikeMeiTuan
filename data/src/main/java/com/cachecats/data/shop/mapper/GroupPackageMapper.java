package com.cachecats.data.shop.mapper;

import com.cachecats.data.shop.entity.GroupPackageEntity;
import com.cachecats.domin.shop.model.GroupPackageModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/25.
 */

public class GroupPackageMapper {

    @Inject
    public GroupPackageMapper() {
    }

    public GroupPackageModel toModel(GroupPackageEntity entity) {
        GroupPackageModel model = new GroupPackageModel();
        model.setCount(entity.count);
        model.setGroupId(entity.groupId);
        model.setId(entity.id);
        model.setName(entity.name);
        model.setPrice(entity.price);
        model.setShopId(entity.shopId);
        model.setTitle(entity.title);
        return model;
    }

    public List<GroupPackageModel> toModels(List<GroupPackageEntity> entities) {
        List<GroupPackageModel> models = new ArrayList<>();
        for (GroupPackageEntity entity : entities) {
            models.add(toModel(entity));
        }
        return models;
    }

    public GroupPackageEntity toEntity(GroupPackageModel model) {
        GroupPackageEntity entity = new GroupPackageEntity();
        entity.count = model.getCount();
        entity.groupId = model.getGroupId();
        entity.id = model.getId();
        entity.name = model.getName();
        entity.price = model.getPrice();
        entity.shopId = model.getShopId();
        entity.title = model.getTitle();
        return entity;
    }

    public List<GroupPackageEntity> toEntities(List<GroupPackageModel> models) {
        List<GroupPackageEntity> entities = new ArrayList<>();
        if(models == null || models.isEmpty()){
            return Collections.emptyList();
        }

        for (GroupPackageModel model : models) {
            entities.add(toEntity(model));
        }
        return entities;
    }
}
