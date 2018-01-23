package com.cachecats.domin.shop.repository;

import com.cachecats.domin.shop.model.ShopModel;

import java.util.List;

/**
 * Created by solo on 2018/1/22.
 */

public interface ShopRepository {

    /**
     * 获取所有商店信息
     */
    List<ShopModel> getAllShops();

    /**
     * 保存单个商店
     * @param model
     * @return
     */
    boolean saveShop(ShopModel model);
}
