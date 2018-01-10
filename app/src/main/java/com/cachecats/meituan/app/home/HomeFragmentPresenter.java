package com.cachecats.meituan.app.home;

import com.cachecats.meituan.R;
import com.cachecats.meituan.base.BasePresenter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by solo on 2018/1/10.
 */

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter{

    private HomeFragmentContract.View mFragment;

    @Inject
    public HomeFragmentPresenter() {

    }

    @Override
    public void setFragment(HomeFragmentContract.View fragment){
        mFragment = fragment;
    }

    @Override
    public void showMessage(){
        mFragment.showToast("Dagger2 --");
    }

    @Override
    public void start() {

    }
}
