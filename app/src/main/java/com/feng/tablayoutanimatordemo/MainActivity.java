package com.feng.tablayoutanimatordemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.feng.tablayoutanimatordemo.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<TestFragment> mFragmentList;   //碎片集合
    private List<String> mPageTitleList;    //tab的标题

    private static final int TAB_NUM = 6;   //标签数
    private List<String> mStrs = Arrays.asList("Java", "Android", "计算机网络", "数据结构",
            "算法", "操作系统");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < TAB_NUM; i++) {
            mFragmentList.add(TestFragment.newInstance(mStrs.get(i), i));
        }

        mPageTitleList = new ArrayList<>();
        for (int i = 0; i < TAB_NUM; i++) {
            mPageTitleList.add(mStrs.get(i));
        }
    }

    private void initView() {
        mViewPager = findViewById(R.id.vp_style_one_content);
        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList, mPageTitleList));

        mTabLayout = findViewById(R.id.tl_style_one_tab);
        mTabLayout.setupWithViewPager(mViewPager);  //将TabLayout与ViewPager关联

        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setScale(0, MyPageTransformer.MAX_SCALE);
            }
        });

        mViewPager.setPageTransformer(false, new MyPageTransformer(mTabLayout));
    }

    /**
     * 将 Tab[index] 放大为初始的 scale 倍
     */
    private void setScale(int index, float scale) {
        LinearLayout ll = (LinearLayout) mTabLayout.getChildAt(0);
        TabLayout.TabView tb = (TabLayout.TabView) ll.getChildAt(0);
        View view  = tb.getTextView();
        view.setScaleX(scale);
        view.setScaleY(scale);
    }
}
