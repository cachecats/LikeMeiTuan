package com.cachecats.meituan.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cachecats.meituan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by solo on 2018/1/7.
 */

public class CustomBottomTabWidget extends LinearLayout {

    @BindView(R.id.ll_menu_home_page)
    LinearLayout llMenuHome;
    @BindView(R.id.ll_menu_nearby)
    LinearLayout llMenuNearby;
    @BindView(R.id.ll_menu_discover)
    LinearLayout llMenuDiscover;
    @BindView(R.id.ll_menu_order)
    LinearLayout llMenuOrder;
    @BindView(R.id.ll_menu_mine)
    LinearLayout llMenuMine;

    public CustomBottomTabWidget(Context context) {
        this(context, null, 0);
    }

    public CustomBottomTabWidget(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomBottomTabWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.widget_custom_bottom_tab, this);
        ButterKnife.bind(view);
    }

    @OnClick({R.id.ll_menu_home_page, R.id.ll_menu_nearby, R.id.ll_menu_discover, R.id.ll_menu_order, R.id.ll_menu_mine})
    public void onViewClicked(View view) {
        //先将所有tab取消选中，再单独设置要选中的tab
        unCheckedAll();
        switch (view.getId()) {
            case R.id.ll_menu_home_page:
                llMenuHome.setActivated(true);
                break;
            case R.id.ll_menu_nearby:
                llMenuNearby.setActivated(true);
                break;
            case R.id.ll_menu_discover:
                llMenuDiscover.setActivated(true);
                break;
            case R.id.ll_menu_order:
                llMenuOrder.setActivated(true);
                break;
            case R.id.ll_menu_mine:
                llMenuMine.setActivated(true);
                break;
        }
    }

    //让所有tab都取消选中
    private void unCheckedAll() {
        llMenuHome.setActivated(false);
        llMenuNearby.setActivated(false);
        llMenuDiscover.setActivated(false);
        llMenuOrder.setActivated(false);
        llMenuMine.setActivated(false);
    }

    //tab的枚举类型
    private enum MenuTab{
        HOME,
        NEARBY,
        DISCOVER,
        ORDER,
        MINE
    }
}
