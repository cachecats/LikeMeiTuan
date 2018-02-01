package com.cachecats.data.shop.repository;

import com.cachecats.data.db.MeituanDB;
import com.cachecats.data.shop.entity.ShopEntity;
import com.cachecats.data.shop.mapper.ShopMapper;
import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.domin.shop.repository.ShopRepository;
import com.orhanobut.logger.Logger;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;

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

    @Override
    public List<ShopModel> getShopsByPage(int page, int pageSize) {
        List<ShopEntity> shopEntities = SQLite.select()
                .from(ShopEntity.class)
                .limit(pageSize)
                .offset(page*pageSize)
                .queryList();
        return mapper.toModels(shopEntities);
    }

    @Override
    public boolean saveShop(ShopModel model) {
        ShopEntity entity = mapper.toEntity(model);
        return entity.save();
    }

    @Override
    public void saveShops(List<ShopModel> models) {
        //开启事务异步批量保存
        final List<ShopEntity> entities = mapper.toEntities(models);
        ProcessModelTransaction<ShopEntity> processModelTransaction =
                new ProcessModelTransaction.Builder<>(new ProcessModelTransaction.ProcessModel<ShopEntity>() {
                    @Override
                    public void processModel(ShopEntity entity, DatabaseWrapper wrapper) {
                        entity.save();
                    }
                }).processListener(new ProcessModelTransaction.OnModelProcessListener<ShopEntity>() {
                    @Override
                    public void onModelProcessed(long current, long total, ShopEntity modifiedModel) {
                        Logger.d("批量保存进度：" + current + "/" + total);
                    }
                }).addAll(entities).build();

        FlowManager.getDatabase(MeituanDB.class)
                .beginTransactionAsync(processModelTransaction)
                .build()
                .execute();
    }

    @Override
    public void clear() {
        SQLite.delete().from(ShopEntity.class).execute();
    }
}
