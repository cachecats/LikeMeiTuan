package com.cachecats.data.shop.repository;

import com.cachecats.data.shop.entity.ShopEntity;
import com.cachecats.data.shop.mapper.ShopMapper;
import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.domin.shop.repository.ShopRepository;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/22.
 */

public class ShopRepositoryImpl implements ShopRepository {

    private ShopMapper mapper;

    @Inject
    public ShopRepositoryImpl(ShopMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ShopModel> getAllShops() {
        List<ShopEntity> shopEntities = SQLite.select().from(ShopEntity.class).queryList();
        return mapper.toModels(shopEntities);
    }
}
