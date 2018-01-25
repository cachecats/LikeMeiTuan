package com.cachecats.domin.shop.repository;

import com.cachecats.domin.shop.model.GroupPackageModel;

import java.util.List;

/**
 * Created by solo on 2018/1/25.
 */

public interface GroupPackageRepository {

    boolean save(GroupPackageModel model);

    void saveGroupPackages(List<GroupPackageModel> models);

}
