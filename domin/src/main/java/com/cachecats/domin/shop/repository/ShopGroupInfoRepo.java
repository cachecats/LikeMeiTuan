package com.cachecats.domin.shop.repository;

import com.cachecats.domin.shop.model.ShopGroupInfoModel;

import java.util.List;

/**
 * Created by solo on 2018/1/25.
 */

public interface ShopGroupInfoRepo {

    boolean save(ShopGroupInfoModel model);

    void saveGroupInfos(List<ShopGroupInfoModel> models);
}
