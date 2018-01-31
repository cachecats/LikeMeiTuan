package com.cachecats.domin.shop.service;

import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.domin.shop.repository.ShopRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by solo on 2018/1/23.
 */

public class ShopService {

    private ShopRepository repository;

    @Inject
    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    /**
     * 获取所有的商店信息
     *
     * @return
     */
    public Single<List<ShopModel>> getAllShops() {
        return Single.create(emitter -> emitter.onSuccess(repository.getAllShops()));
    }

    /**
     * 分页获取商店信息
     * @param pageSize 每页大小
     * @return
     */
     public Single<List<ShopModel>> getShopsByPage(int page, int pageSize) {
        return Single.create(emitter -> emitter.onSuccess(repository.getShopsByPage(page, pageSize)));
    }


    /**
     * 保存单个商店信息
     *
     * @param model
     * @return 返回保存结果
     */
    public Single<Boolean> saveShop(final ShopModel model) {
        return Single.create(emitter -> emitter.onSuccess(repository.saveShop(model)));
    }

    /**
     * 批量异步保存
     *
     * @param models
     * @return
     */
    public Completable saveShops(List<ShopModel> models) {
        return Completable.create(emitter -> {
            repository.saveShops(models);
            emitter.onComplete();
        });
    }

    /**
     * 清空数据库
     *
     * @return
     */
    public Completable clear() {
        return Completable.create(emitter -> {
            repository.clear();
            emitter.onComplete();
        });
    }


}
