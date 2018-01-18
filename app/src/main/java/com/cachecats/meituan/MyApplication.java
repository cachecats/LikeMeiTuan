package com.cachecats.meituan;

import android.app.Application;
import android.content.Context;

import com.cachecats.meituan.di.components.ApplicationComponent;
import com.cachecats.meituan.di.components.DaggerApplicationComponent;
import com.cachecats.meituan.di.modules.ApplicationModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by solo on 2018/1/7.
 */

public class MyApplication extends Application {

    private static Context mContext;
    private static MyApplication application;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        mContext = getApplicationContext();
        Logger.addLogAdapter(new AndroidLogAdapter());

        //Dagger注入
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);

        //初始化数据库
        FlowManager.init(this);

    }

    /**
     * 获取ApplicationContext
     *
     * @return
     */
    public static Context getAppContext() {
        return mContext;
    }


    private ApplicationComponent getComponent(){
        return mApplicationComponent;
    }

    /**
     * 获取 ApplicationComponent
     *
     * @return
     */
    public static ApplicationComponent getApplicationComponent() {
        return application.getComponent();
    }

}
