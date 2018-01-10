package com.cachecats.meituan.app;

import android.os.Bundle;

import com.cachecats.meituan.MyApplication;
import com.cachecats.meituan.R;
import com.cachecats.meituan.app.discover.DiscoverFragment;
import com.cachecats.meituan.app.home.HomeFragment;
import com.cachecats.meituan.app.mine.MineFragment;
import com.cachecats.meituan.app.nearby.NearbyFragment;
import com.cachecats.meituan.app.order.OrderFragment;
import com.cachecats.meituan.base.BaseActivity;
import com.cachecats.meituan.base.BaseFragment;
import com.cachecats.meituan.di.DIHelper;
import com.cachecats.meituan.di.components.DaggerActivityComponent;
import com.cachecats.meituan.di.modules.ActivityModule;
import com.cachecats.meituan.widget.bottomtab.CustomBottomTabWidget;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tabWidget)
    CustomBottomTabWidget tabWidget;
    private List<BaseFragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerActivityComponent.builder()
                .applicationComponent(MyApplication.getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build().inject(this);

        //初始化
        init();
    }

    private void init() {
        //构造Fragment的集合
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new NearbyFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new OrderFragment());
        fragmentList.add(new MineFragment());
        //初始化CustomBottomTabWidget
        tabWidget.init(getSupportFragmentManager(), fragmentList);
    }
}
