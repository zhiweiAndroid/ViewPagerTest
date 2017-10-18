package com.example.shundai.viewpagertest;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BaseViewpager vp;
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments=new ArrayList<>();
        vp = (BaseViewpager) findViewById(R.id.vp);
        LeftFragment leftFragment=new LeftFragment();
        RightFragment rightFragment=new RightFragment();
        TextView tv=new TextView(this);
        tv.setText("hello world");
        fragments.add(leftFragment);
        Button bt=new Button(this);
        bt.setText("点击");
        fragments.add(rightFragment);
        vp.setPageMargin(DensityUtils.dp2px(this,10));
//        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vp.getLayoutParams();
//        layoutParams.height=DensityUtils.dp2px(MainActivity.this,250);
//        vp.setLayoutParams(layoutParams);
        MainFragmentAdapter adapter=new MainFragmentAdapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(adapter);
        //设置监听事件   设置间距
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0)
                {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vp.getLayoutParams();
                    layoutParams.rightMargin=DensityUtils.dp2px(MainActivity.this,10);
                    layoutParams.leftMargin=0;
                    vp.setLayoutParams(layoutParams);
                }else
                {

                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vp.getLayoutParams();
                    layoutParams.rightMargin=0;
                    layoutParams.leftMargin=DensityUtils.dp2px(MainActivity.this,10);
                    vp.setLayoutParams(layoutParams);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
