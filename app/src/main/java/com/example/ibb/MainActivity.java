package com.example.ibb;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ibb.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TabLayout home_tabLayout;
    private ViewPager home_viewPager;

    List<String> titleList=new ArrayList<String>();
    List<Fragment> fragmentList=new ArrayList<>();



    /**
     * 找id
     */
    @Override
    protected void initview() {

        home_tabLayout = (TabLayout) findViewById(R.id.home_tabLayout);
        home_viewPager =(ViewPager)findViewById(R.id.home_viewPager);

    }

    @Override
    protected void initdata() {

        titleList.add("发现");
        titleList.add("关注");
        //在代码里面写tablayout的标签
        home_tabLayout.addTab(home_tabLayout.newTab().setText(titleList.get(0)));
        home_tabLayout.addTab(home_tabLayout.newTab().setText(titleList.get(1)));

        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());

        //初始化Adapter
        MyViewPagerAdapter viewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager());
        home_viewPager.setAdapter(viewPagerAdapter);
        //用来绑定viewpager和tablayout的
        home_tabLayout.setupWithViewPager(home_viewPager);

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main;
    }


    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
