package com.cachecats.meituan.di.modules;

import android.app.Application;
import android.content.Context;

import com.cachecats.meituan.app.home.HomeFragment;
import com.cachecats.meituan.app.home.HomeFragmentContract;
import com.cachecats.meituan.app.home.HomeFragmentPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by solo on 2018/1/10.
 */

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @Provides
    public Context provideContext(){
        return application.getApplicationContext();
    }

    @Provides
    HomeFragmentContract.Presenter providePresenter(HomeFragmentPresenter presenter){
        return presenter;
    }

}
