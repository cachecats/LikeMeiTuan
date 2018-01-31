package com.cachecats.meituan.app.home;

import android.content.Context;
import android.widget.LinearLayout;

import com.cachecats.domin.shop.model.GroupPackageModel;
import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.domin.shop.service.GroupPackageService;
import com.cachecats.domin.shop.service.ShopService;
import com.cachecats.meituan.R;
import com.cachecats.meituan.app.home.model.IconTitleModel;
import com.cachecats.meituan.mock.MockUtils;
import com.cachecats.meituan.utils.ToastUtils;
import com.cachecats.meituan.widget.IconTitleView;
import com.orhanobut.logger.Logger;
import com.solo.common.rxjava.CloseableRxServiceExecutor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by solo on 2018/1/10.
 */

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {

    //大模块的图片数组
    private static final int[] bigModuleDrawables = {
            R.mipmap.homepage_icon_light_food_b,
            R.mipmap.homepage_icon_light_movie_b,
            R.mipmap.homepage_icon_light_hotel_b,
            R.mipmap.homepage_icon_light_amusement_b,
            R.mipmap.homepage_icon_light_takeout_b,
    };

    //大模块的标题数组
    private static final String[] bigMudoleTitles = {
            "美食", "电影/演出", "酒店住宿", "休闲娱乐", "外卖"
    };

    private HomeFragmentContract.View mFragment;
    private Context mContext;
    private ShopService shopService;
    private GroupPackageService groupPackageService;
    private MockUtils mockUtils;
    private CloseableRxServiceExecutor executor;


    @Inject
    public HomeFragmentPresenter(Context context,
                                 ShopService shopService,
                                 GroupPackageService groupPackageService,
                                 MockUtils mockUtils,
                                 CloseableRxServiceExecutor executor) {
        mContext = context;
        this.shopService = shopService;
        this.groupPackageService = groupPackageService;
        this.mockUtils = mockUtils;
        this.executor = executor;
    }

    @Override
    public void setContractView(HomeFragmentContract.View fragment) {
        mFragment = fragment;
    }

    @Override
    public void onStart() {

        initBigModule();
//        mockUtils.mockShopDataToDB();
//        mockUtils.clearShop();
//        mockUtils.mockGroupPackagesToDB();
//        getAllShops();
//        mockUtils.mockGroupInfoData();
        getShopsByPage(0, 10);
    }

    @Override
    public void onDestroy() {

    }



    /**
     * 获取所有的商铺信息
     */
    private void getAllShops() {
        executor.execute(shopService.getAllShops(), shopModels -> {
            Logger.d(shopModels);
            mFragment.setShopListData(shopModels);
        });
    }

    /**
     * 分页获取商店信息
     * @param page 当前页
     * @param pageSize 每页大小
     */
    private void getShopsByPage(int page, int pageSize){
        executor.execute(shopService.getShopsByPage(page, pageSize), shopModels -> {
            Logger.d(shopModels);
            mFragment.setShopListData(shopModels);
        });
    }


    /**
     * 初始化banner下面的5个大模块
     */
    private void initBigModule() {
        for (int i = 0; i < 5; i++) {
            IconTitleView iconTitleView = IconTitleView.newInstance(mContext, bigModuleDrawables[i], bigMudoleTitles[i]);
            // 设置宽高和权重weight，使每个View占用相同的宽度
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            iconTitleView.setLayoutParams(lp);

            // 往根布局上添加View
            mFragment.addViewToBigModule(iconTitleView);

            //给View添加点击事件
            int finalI = i;
            iconTitleView.setOnClickListener((view) -> {
                Logger.d(bigMudoleTitles[finalI]);
                ToastUtils.show(bigMudoleTitles[finalI]);
            });
        }
    }

    /**
     * 获取Banner的图片资源
     *
     * @return
     */
    @Override
    public List<Integer> getBannerImages() {
        List<Integer> mBannerImages = new ArrayList<>();
        mBannerImages.add(R.mipmap.banner1);
        mBannerImages.add(R.mipmap.banner2);
        mBannerImages.add(R.mipmap.banner3);
        mBannerImages.add(R.mipmap.banner4);
        mBannerImages.add(R.mipmap.banner5);
        mBannerImages.add(R.mipmap.banner6);
        return mBannerImages;
    }

    /**
     * 获取包含两行小模块的图标、标题的对象的集合
     *
     * @return
     */
    @Override
    public List<IconTitleModel> getIconTitleModels() {
        List<IconTitleModel> datas = new ArrayList<>();
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_ktv_s, "KTV"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_toursaround_s, "周边游"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_transportation_s, "机票/火车票"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_beauty_s, "丽人/美发"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_travel_s, "旅游/出行"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_fitness_s, "跑腿/代购"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_amusement_s, "景点/门票"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_bath_s, "温泉"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_lifeservice_s, "榛果民宿"));
        datas.add(new IconTitleModel(R.mipmap.homepage_icon_light_more_s, "全部分类"));
        return datas;
    }


}
