package com.cachecats.meituan.di.components;

import android.app.Application;
import android.content.Context;

import com.cachecats.data.shop.mapper.GroupPackageMapper;
import com.cachecats.data.shop.mapper.ShopEvaluateMapper;
import com.cachecats.data.shop.mapper.ShopGroupInfoMapper;
import com.cachecats.data.shop.mapper.ShopMapper;
import com.cachecats.domin.shop.repository.GroupPackageRepository;
import com.cachecats.domin.shop.repository.ShopGroupInfoRepo;
import com.cachecats.domin.shop.repository.ShopRepository;
import com.cachecats.domin.shop.service.GroupPackageService;
import com.cachecats.domin.shop.service.ShopGroupInfoService;
import com.cachecats.domin.shop.service.ShopService;
import com.cachecats.meituan.MyApplication;
import com.cachecats.meituan.app.home.HomeFragmentContract;
import com.cachecats.meituan.app.home.HomeFragmentPresenter;
import com.cachecats.meituan.di.modules.ApplicationModule;
import com.cachecats.meituan.mock.MockUtils;
import com.solo.common.rxjava.CloseableRxServiceExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by solo on 2018/1/10.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    Application application();

    Context context();

    HomeFragmentPresenter presenter();

    HomeFragmentContract.Presenter homeFragmentContractPresenter();

    ShopMapper shopMapper();

    ShopRepository shopRepository();

    ShopService shopService();

    ShopEvaluateMapper shopEvaluateMapper();

    GroupPackageMapper groupPackageMapper();

    ShopGroupInfoMapper shopGroupInfoMapper();

    GroupPackageRepository groupPackageRepository();

    GroupPackageService groupPackageService();

    MockUtils mockUtils();

    ShopGroupInfoRepo shopGroupInfoRepo();

    ShopGroupInfoService shopGroupInfoService();

    CloseableRxServiceExecutor closeableRxServiceExecutor();
}
