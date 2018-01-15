package com.cachecats.meituan.app.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cachecats.meituan.MyApplication;
import com.cachecats.meituan.R;
import com.cachecats.meituan.app.home.adapter.LittleModuleAdapter;
import com.cachecats.meituan.app.home.model.IconTitleModel;
import com.cachecats.meituan.base.BaseFragment;
import com.cachecats.meituan.di.components.DaggerActivityComponent;
import com.cachecats.meituan.utils.GlideImageLoader;
import com.cachecats.meituan.utils.ToastUtils;
import com.cachecats.meituan.widget.HomeAdsView;
import com.cachecats.meituan.widget.IconTitleView;
import com.cachecats.meituan.widget.decoration.HomeGridDecoration;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by solo on 2018/1/8.
 */

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {

    @BindView(R.id.home_banner)
    Banner banner;
    //大模块的LinearLayout布局
    @BindView(R.id.ll_big_module_fragment_home)
    LinearLayout llBigModule;
    @BindView(R.id.recyclerview_little_module)
    RecyclerView littleModuleRecyclerView;
    @BindView(R.id.home_ads_view)
    HomeAdsView homeAdsView;

    @Inject
    HomeFragmentContract.Presenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        //绑定 ButterKnife
        ButterKnife.bind(this, view);

        DaggerActivityComponent.builder()
                .applicationComponent(MyApplication.getApplicationComponent())
                .build()
                .inject(this);

        presenter.setContractView(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBanner();
        initLittleModuleRecyclerView();
        initAds();
    }

    private void initAds() {
        homeAdsView.setOnAdsClickListener(new HomeAdsView.OnAdsClickListener() {
            @Override
            public void onAds1Click() {
                ToastUtils.show("Ads1");
            }

            @Override
            public void onAds2Click() {
                ToastUtils.show("Ads2");
            }

            @Override
            public void onAds3Click() {
                ToastUtils.show("Ads3");
            }

            @Override
            public void onAds4Click() {
                ToastUtils.show("Ads4");
            }
        });
    }

    /**
     * 初始化小模块的RecyclerView
     */
    private void initLittleModuleRecyclerView() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        //设置LayoutManager
        littleModuleRecyclerView.setLayoutManager(gridLayoutManager);
        //设置分割器
        littleModuleRecyclerView.addItemDecoration(new HomeGridDecoration(12));
        //设置动画
        littleModuleRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置Adapter
        List<IconTitleModel> iconTitleModels = presenter.getIconTitleModels();
        LittleModuleAdapter littleModuleAdapter = new LittleModuleAdapter(
                R.layout.view_icon_title_small, iconTitleModels);

        littleModuleRecyclerView.setAdapter(littleModuleAdapter);
        //设置item点击事件
        littleModuleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.show(iconTitleModels.get(position).getTitle());
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        //增加banner的体验
        banner.startAutoPlay();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        //增加banner的体验
        banner.stopAutoPlay();
    }

    public void initBanner() {
        //设置banner的各种属性
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .setImages(presenter.getBannerImages())
                .setBannerAnimation(Transformer.Default)
                .isAutoPlay(true)
                .setDelayTime(3000)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();
    }

    /**
     * 往根布局上添加View
     */
    @Override
    public void addViewToBigModule(IconTitleView iconTitleView) {
        llBigModule.addView(iconTitleView);
    }


}
