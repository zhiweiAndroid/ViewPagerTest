package com.example.shundai.viewpagertest;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by win7 on 2017/10/18.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private  FragmentManager fm;
    private  List<Fragment> fragments;

    public MainFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
        this.fm=fm;
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view==object;
//    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView((View) object);
//    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        this.fm.beginTransaction().show(fragment).commitAllowingStateLoss();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = fragments.get(position);
        fm.beginTransaction().hide(fragment).commitAllowingStateLoss();
    }

}
