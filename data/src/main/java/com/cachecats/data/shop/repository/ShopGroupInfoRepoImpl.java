package com.cachecats.data.shop.repository;

import com.cachecats.data.db.MeituanDB;
import com.cachecats.data.shop.entity.ShopGroupInfoEntity;
import com.cachecats.data.shop.mapper.ShopGroupInfoMapper;
import com.cachecats.domin.shop.model.ShopGroupInfoModel;
import com.cachecats.domin.shop.repository.ShopGroupInfoRepo;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/25.
 */

public class ShopGroupInfoRepoImpl implements ShopGroupInfoRepo {

    private ShopGroupInfoMapper mapper;

    @Inject
    public ShopGroupInfoRepoImpl(ShopGroupInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean save(ShopGroupInfoModel model) {
        ShopGroupInfoEntity entity = mapper.toEntity(model);
        return entity.save();
    }

    @Override
    public void saveGroupInfos(List<ShopGroupInfoModel> models) {
        FastStoreModelTransaction<ShopGroupInfoEntity> transaction = FastStoreModelTransaction
                .saveBuilder(FlowManager.getModelAdapter(ShopGroupInfoEntity.class))
                .addAll(mapper.toEntities(models))
                .build();
        FlowManager.getDatabase(MeituanDB.class)
                .beginTransactionAsync(transaction)
                .build().execute();
    }
}
