package com.cachecats.meituan;

import android.app.Application;
import android.content.Context;

import com.cachecats.meituan.di.components.ApplicationComponent;
import com.cachecats.meituan.di.components.DaggerApplicationComponent;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by solo on 2018/1/7.
 */

public class MyApplication extends Application {

    private static Context mContext;
    private static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        Logger.addLogAdapter(new AndroidLogAdapter());

        //Dagger注入
        mApplicationComponent = DaggerApplicationComponent.builder().build();
        mApplicationComponent.inject(this);
    }

    /**
     * 获取ApplicationContext
     *
     * @return
     */
    public static Context getAppContext() {
        return mContext;
    }


    /**
     * 获取 ApplicationComponent
     *
     * @return
     */
    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
