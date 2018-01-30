package com.cachecats.meituan.app.home;

import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.meituan.app.home.model.IconTitleModel;
import com.cachecats.meituan.base.BasePresenter;
import com.cachecats.meituan.base.BaseView;
import com.cachecats.meituan.widget.HomeAdsView;
import com.cachecats.meituan.widget.IconTitleView;

import java.util.List;

/**
 * Created by solo on 2018/1/10.
 */

public interface HomeFragmentContract {

    interface View {

        void addViewToBigModule(IconTitleView iconTitleView);

        void setShopListData(List<ShopModel> shopModels);
    }

    interface Presenter extends BasePresenter<View>{

        List<Integer> getBannerImages();

        List<IconTitleModel> getIconTitleModels();
    }
}
