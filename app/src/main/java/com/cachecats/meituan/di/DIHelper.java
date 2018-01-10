package com.cachecats.meituan.di;

import com.cachecats.meituan.MyApplication;
import com.cachecats.meituan.di.components.ActivityComponent;
import com.cachecats.meituan.di.components.DaggerActivityComponent;

/**
 * Created by solo on 2018/1/10.
 * 依赖注入帮助类
 */

public class DIHelper {

    public static ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .applicationComponent(MyApplication.getApplicationComponent())
                .build();
    }
}
