package com.cachecats.meituan.app.home;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.domin.shop.service.ShopService;
import com.cachecats.meituan.R;
import com.cachecats.meituan.app.home.model.IconTitleModel;
import com.cachecats.meituan.base.BasePresenter;
import com.cachecats.meituan.utils.ToastUtils;
import com.cachecats.meituan.widget.IconTitleView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
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
    private ShopService service;

    @Inject
    public HomeFragmentPresenter(Context context, ShopService service) {
        mContext = context;
        this.service = service;
    }

    @Override
    public void setContractView(HomeFragmentContract.View fragment) {
        mFragment = fragment;
    }

    @Override
    public void start() {
        initBigModule();
//        mockShopDataToDB();
        getAllShops();
    }

    private void getAllShops() {
        Single<List<ShopModel>> single = service.getAllShops();
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<ShopModel>>() {
//                    @Override
//                    public void accept(List<ShopModel> shopModels) throws Exception {
//                        Logger.d(shopModels);
//                    }
//                });
                .subscribe(shopModels -> {
                    Logger.d(shopModels);
                });
    }


    //制造商铺信息保存到数据库
    private void mockShopDataToDB() {
        for (int i = 0; i < 50; i++) {
            ShopModel model = new ShopModel();
            model.setTel("1890028332"+i);
            model.setServiceScore(4.5f);
            model.setRecommendDishes("家常豆腐"+i);
            model.setPerConsume(45+i);
            model.setName("张三"+i);
            model.setIntroduction("旺铺欢迎光临");
            model.setId(i+"");
            model.setAddress("北辰大道"+i);

            Single<Boolean> single = service.saveShop(model);
            single.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Boolean>() {
                        @Override
                        public void accept(Boolean aBoolean) throws Exception {
                            Logger.d("保存结果:" + aBoolean);
                        }
                    });
        }
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
