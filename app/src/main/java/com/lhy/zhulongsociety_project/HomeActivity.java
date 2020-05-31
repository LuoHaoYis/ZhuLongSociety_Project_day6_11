package com.lhy.zhulongsociety_project;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lhy.fragments.CourseFragment;
import com.lhy.fragments.DatumFragment;
import com.lhy.fragments.HomeFragment;
import com.lhy.fragments.MyFragment;
import com.lhy.fragments.VIPFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setSupportActionBar(toolbar);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CourseFragment());
        fragments.add(new VIPFragment());
        fragments.add(new DatumFragment());
        fragments.add(new MyFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("首页").setIcon(R.drawable.xuan1);
        tabLayout.getTabAt(1).setText("课程").setIcon(R.drawable.xuan2);
        tabLayout.getTabAt(2).setText("VIP").setIcon(R.drawable.xuan3);
        tabLayout.getTabAt(3).setText("资料").setIcon(R.drawable.xuan4);
        tabLayout.getTabAt(4).setText("我的").setIcon(R.drawable.xuan5);
        tabLayout.setSelectedTabIndicatorHeight(0);
    }
}
