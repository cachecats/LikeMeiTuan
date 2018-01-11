package com.cachecats.meituan.app.home;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.cachecats.meituan.R;
import com.cachecats.meituan.base.BasePresenter;
import com.cachecats.meituan.utils.ToastUtils;
import com.cachecats.meituan.widget.IconTitleView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/10.
 */

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter{

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

    @Inject
    public HomeFragmentPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void setContractView(HomeFragmentContract.View fragment){
        mFragment = fragment;
    }

    @Override
    public void start() {
        initBigModule();
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


}
