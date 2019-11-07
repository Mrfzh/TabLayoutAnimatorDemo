package com.feng.tablayoutanimatordemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Feng Zhaohao
 * Created on 2018/9/2
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<TestFragment> mFragmentList;   //碎片集合
    private List<String> mPageTitleList;    //tab的标题

    public MyViewPagerAdapter(FragmentManager fm, List<TestFragment> mFragmentList, List<String> mPageTitleList) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.mPageTitleList = mPageTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    /**
     * 当TabLayout与ViewPager绑定的时候能够绑定Tab标签的标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mPageTitleList.get(position);
    }
}
