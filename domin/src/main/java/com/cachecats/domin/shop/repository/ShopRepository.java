package com.cachecats.domin.shop.repository;

import com.cachecats.domin.shop.model.ShopModel;

import java.util.List;

/**
 * Created by solo on 2018/1/22.
 */

public interface ShopRepository {

    List<ShopModel> getAllShops();
}
