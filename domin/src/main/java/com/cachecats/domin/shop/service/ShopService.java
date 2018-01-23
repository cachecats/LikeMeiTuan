package com.cachecats.domin.shop.service;

import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.domin.shop.repository.ShopRepository;

import java.net.ResponseCache;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

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
     * @return
     */
    public Single<List<ShopModel>> getAllShops() {
        return Single.create(new SingleOnSubscribe<List<ShopModel>>() {
            @Override
            public void subscribe(SingleEmitter<List<ShopModel>> emitter) throws Exception {
                emitter.onSuccess(repository.getAllShops());
            }
        });
    }

    /**
     * 保存单个商店信息
     * @param model
     * @return 返回保存结果
     */
    public Single<Boolean> saveShop(final ShopModel model){
        return Single.create(new SingleOnSubscribe<Boolean>() {
            @Override
            public void subscribe(SingleEmitter<Boolean> emitter) throws Exception {
                emitter.onSuccess(repository.saveShop(model));
            }
        });
    }


}
