package com.example.dell.m2_week01;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.dell.m2_week01.fragment.FirstFragment;
import com.example.dell.m2_week01.fragment.FiveFragment;
import com.example.dell.m2_week01.fragment.FourFragment;
import com.example.dell.m2_week01.fragment.SecondFragment;
import com.example.dell.m2_week01.fragment.ThiedFragment;
import com.example.dell.m2_week01.home.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private RadioGroup radio;
    private ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);
        view_pager = findViewById(R.id.view_pager);
        radio = findViewById(R.id.radio);
        List<Fragment> list = new ArrayList<>();
        list.add(new FirstFragment());
        list.add(new SecondFragment());
        list.add(new ThiedFragment());
        list.add(new FourFragment());
        list.add(new FiveFragment());
        view_pager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), list));
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        view_pager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        view_pager.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        view_pager.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        view_pager.setCurrentItem(3);
                        break;
                    case R.id.rb5:
                        view_pager.setCurrentItem(4);
                        break;
                }
            }
        });
        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radio.check(radio.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
