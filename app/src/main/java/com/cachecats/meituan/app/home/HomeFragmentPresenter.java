package com.cachecats.meituan.app.home;

import com.cachecats.meituan.R;
import com.cachecats.meituan.base.BasePresenter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/10.
 */

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {

    private HomeFragmentContract.View mHomeFragmentView;

    @Inject
    public HomeFragmentPresenter(HomeFragmentContract.View homeFragmentView) {
        mHomeFragmentView = homeFragmentView;
    }

    @Override
    public void start() {
        Logger.d("Presenter onStart-------");
    }

    @Override
    public void createIconTitleViews() {

    }

    @Override
    public List<Integer> getBannerImages() {
        //设置图片集合
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
