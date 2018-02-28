package com.cachecats.meituan.app.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cachecats.domin.shop.model.ShopModel;
import com.cachecats.meituan.MyApplication;
import com.cachecats.meituan.R;
import com.cachecats.meituan.app.home.adapter.LittleModuleAdapter;
import com.cachecats.meituan.app.home.adapter.ShopListAdapter;
import com.cachecats.meituan.app.home.model.IconTitleModel;
import com.cachecats.meituan.base.BaseFragment;
import com.cachecats.meituan.di.components.DaggerActivityComponent;
import com.cachecats.meituan.utils.GlideImageLoader;
import com.cachecats.meituan.utils.ToastUtils;
import com.cachecats.meituan.widget.refresh.CustomRefreshFooter;
import com.cachecats.meituan.widget.refresh.CustomRefreshHeader;
import com.cachecats.meituan.widget.HomeAdsView;
import com.cachecats.meituan.widget.IconTitleView;
import com.cachecats.meituan.widget.decoration.DividerItemDecoration;
import com.cachecats.meituan.widget.decoration.HomeGridDecoration;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.Collections;
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
    //小模块GridView布局
    @BindView(R.id.recyclerview_little_module)
    RecyclerView littleModuleRecyclerView;
    //4块广告封装成的自定义View
    @BindView(R.id.home_ads_view)
    HomeAdsView homeAdsView;
    //团购商店列表
    @BindView(R.id.recycler_view_shops)
    RecyclerView rvShopList;
    //下拉刷新组件
    @BindView(R.id.smartRefreshLayout_home)
    SmartRefreshLayout smartRefreshLayout;

    @Inject
    HomeFragmentContract.Presenter presenter;

    private ShopListAdapter mShopListAdapter;
    private List<ShopModel> mShopModels = Collections.emptyList();


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
        init();
    }

    private void init() {
        initBanner();
        initLittleModuleRecyclerView();
        initAds();
        initShopList();
        initSmartRefreshLayout();
    }


    //初始化下拉刷新控件
    private void initSmartRefreshLayout() {
        smartRefreshLayout.setRefreshHeader(new CustomRefreshHeader(getActivity()));
        smartRefreshLayout.setRefreshFooter(new CustomRefreshFooter(getActivity(), "加载中…"));
        smartRefreshLayout.setEnableScrollContentWhenLoaded(true);//是否在加载完成时滚动列表显示新的内容
        smartRefreshLayout.setEnableFooterFollowWhenLoadFinished(true);
        smartRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                presenter.onLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.onRefresh();
            }
        });


    }

    @Override
    public void finishLoadmore(boolean success) {
        smartRefreshLayout.finishLoadmore(success);
    }

    @Override
    public void finishLoadmoreWithNoMoreData() {
        smartRefreshLayout.finishLoadmoreWithNoMoreData();
    }

    @Override
    public void finishRefresh(boolean success) {
        smartRefreshLayout.finishRefresh(success);
    }

    @Override
    public void resetNoMoreData() {
        smartRefreshLayout.resetNoMoreData();
    }

    /**
     * 加载更多后添加新的数据到RecyclerView
     * @param shopModels
     */
    @Override
    public void addData2RecyclerView(List<ShopModel> shopModels) {
        mShopListAdapter.addData(shopModels);
    }

    @Override
    public void setRefreshFooter(RefreshFooter footer) {
        smartRefreshLayout.setRefreshFooter(footer);
    }

    private void initShopList() {
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvShopList.setLayoutManager(lm);
        rvShopList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        rvShopList.setItemAnimator(new DefaultItemAnimator());
        mShopListAdapter = new ShopListAdapter(getActivity(), R.layout.item_home_shop_list, mShopModels);
//        mShopListAdapter.setUpFetchEnable(true);
        rvShopList.setAdapter(mShopListAdapter);
//        mShopListAdapter.setEmptyView();
    }

    @Override
    public void setShopListData(List<ShopModel> shopModels) {
        mShopListAdapter.setNewData(shopModels);
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
        presenter.onStart();
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


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
