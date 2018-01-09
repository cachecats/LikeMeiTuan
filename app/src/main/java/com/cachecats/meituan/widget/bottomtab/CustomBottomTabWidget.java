package com.cachecats.meituan.widget.bottomtab;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.cachecats.meituan.R;
import com.cachecats.meituan.base.BaseFragment;

import java.util.List;

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
    @BindView(R.id.vp_tab_widget)
    ViewPager viewPager;

    private FragmentManager mFragmentManager;
    private List<BaseFragment> mFragmentList;
    private TabPagerAdapter mAdapter;

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

        //设置默认的选中项
        selectTab(MenuTab.HOME);

    }

    /**
     * 外部调用初始化，传入必要的参数
     *
     * @param fm
     */
    public void init(FragmentManager fm, List<BaseFragment> fragmentList) {
        mFragmentManager = fm;
        mFragmentList = fragmentList;
        initViewPager();
    }

    /**
     * 初始化 ViewPager
     */
    private void initViewPager() {
        mAdapter = new TabPagerAdapter(mFragmentManager, mFragmentList);
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //将ViewPager与下面的tab关联起来
                switch (position) {
                    case 0:
                        selectTab(MenuTab.HOME);
                        break;
                    case 1:
                        selectTab(MenuTab.NEARBY);
                        break;
                    case 2:
                        selectTab(MenuTab.DISCOVER);
                        break;
                    case 3:
                        selectTab(MenuTab.ORDER);
                        break;
                    case 4:
                        selectTab(MenuTab.MINE);
                        break;
                    default:
                        selectTab(MenuTab.HOME);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 点击事件集合
     */
    @OnClick({R.id.ll_menu_home_page, R.id.ll_menu_nearby, R.id.ll_menu_discover, R.id.ll_menu_order, R.id.ll_menu_mine})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.ll_menu_home_page:
                selectTab(MenuTab.HOME);
                //使ViewPager跟随tab点击事件滑动
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_menu_nearby:
                selectTab(MenuTab.NEARBY);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_menu_discover:
                selectTab(MenuTab.DISCOVER);
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_menu_order:
                selectTab(MenuTab.ORDER);
                viewPager.setCurrentItem(3);
                break;
            case R.id.ll_menu_mine:
                selectTab(MenuTab.MINE);
                viewPager.setCurrentItem(4);
                break;
        }
    }

    /**
     * 设置 Tab 的选中状态
     *
     * @param tab 要选中的标签
     */
    public void selectTab(MenuTab tab) {
        //先将所有tab取消选中，再单独设置要选中的tab
        unCheckedAll();

        switch (tab) {
            case HOME:
                llMenuHome.setActivated(true);
                break;
            case NEARBY:
                llMenuNearby.setActivated(true);
                break;
            case DISCOVER:
                llMenuDiscover.setActivated(true);
                break;
            case ORDER:
                llMenuOrder.setActivated(true);
                break;
            case MINE:
                llMenuMine.setActivated(true);
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

    /**
     * tab的枚举类型
     */
    public enum MenuTab {
        HOME,
        NEARBY,
        DISCOVER,
        ORDER,
        MINE
    }
}
