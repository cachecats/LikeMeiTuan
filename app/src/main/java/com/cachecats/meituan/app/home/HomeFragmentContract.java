package com.cachecats.meituan.app.home;

import com.cachecats.meituan.base.BasePresenter;
import com.cachecats.meituan.base.BaseView;
import com.cachecats.meituan.widget.IconTitleView;

import java.util.List;

/**
 * Created by solo on 2018/1/10.
 */

public interface HomeFragmentContract {

    interface View {

        void addViewToBigModule(IconTitleView iconTitleView);
    }

    interface Presenter extends BasePresenter<View>{

        List<Integer> getBannerImages();
    }
}
