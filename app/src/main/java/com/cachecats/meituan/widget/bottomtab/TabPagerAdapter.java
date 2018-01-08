package com.cachecats.meituan.widget.bottomtab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cachecats.meituan.base.BaseFragment;

import java.util.List;

/**
 * Created by solo on 2018/1/8.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragmentList;
    private FragmentManager fm;

    public TabPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fm = fm;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
