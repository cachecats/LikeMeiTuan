package com.cachecats.data.shop.repository;

import com.cachecats.data.db.MeituanDB;
import com.cachecats.data.shop.entity.GroupPackageEntity;
import com.cachecats.data.shop.mapper.GroupPackageMapper;
import com.cachecats.domin.shop.model.GroupPackageModel;
import com.cachecats.domin.shop.repository.GroupPackageRepository;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/25.
 */

public class GroupPackageRepoImpl implements GroupPackageRepository {

    private GroupPackageMapper mapper;

    @Inject
    public GroupPackageRepoImpl(GroupPackageMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean save(GroupPackageModel model) {
        GroupPackageEntity entity = mapper.toEntity(model);
        return entity.save();
    }

    @Override
    public void saveGroupPackages(List<GroupPackageModel> models) {
        //快速异步事务存储
        FastStoreModelTransaction<GroupPackageEntity> transaction = FastStoreModelTransaction
                .saveBuilder(FlowManager.getModelAdapter(GroupPackageEntity.class))
                .addAll(mapper.toEntities(models))
                .build();
        FlowManager.getDatabase(MeituanDB.class)
                .beginTransactionAsync(transaction)
                .build()
                .execute();
    }
}
