package com.cachecats.meituan.app.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cachecats.meituan.R;
import com.cachecats.meituan.base.BaseFragment;
import com.cachecats.meituan.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by solo on 2018/1/8.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_banner)
    Banner banner;

    private List<Drawable> mBannerImages;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBanner();
    }

    private void initBanner() {
        //设置图片集合
         mBannerImages = new ArrayList<>();
         mBannerImages.add(getResources().getDrawable(R.mipmap.banner1));
         mBannerImages.add(getResources().getDrawable(R.mipmap.banner2));
         mBannerImages.add(getResources().getDrawable(R.mipmap.banner3));
         mBannerImages.add(getResources().getDrawable(R.mipmap.banner4));
         mBannerImages.add(getResources().getDrawable(R.mipmap.banner5));
         mBannerImages.add(getResources().getDrawable(R.mipmap.banner6));

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .setImages(mBannerImages)
                .setBannerAnimation(Transformer.DepthPage)
                .isAutoPlay(true)
                .setDelayTime(3000)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();
    }
}
