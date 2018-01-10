package com.cachecats.meituan.di.components;

import com.cachecats.meituan.app.home.HomeFragment;
import com.cachecats.meituan.di.modules.FragmentModule;
import com.cachecats.meituan.di.scopes.Scopes;

import dagger.Component;

/**
 * Created by solo on 2018/1/10.
 */

@Scopes.Fragment
@Component(modules = {FragmentModule.class}, dependencies = {ApplicationComponent.class})
public interface FragmentComponent {

    void inject(HomeFragment fragment);
}
