package com.xiong.video.youku;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.xiong.video.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 优酷视频Activity
 * Created by 杨超 on 2016/4/27.
 */
public class YouKuActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tab)
    TabLayout mTabLayout;
    @Bind(R.id.viewpage)
    ViewPager mViewPager;
    private List<Fragment> mFragments;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youku);
        ButterKnife.bind(this);
        setActionBar(mToolbar);
        final String[] category = getResources().getStringArray(R.array.category);
        mFragments = new ArrayList<>();
        for (String aCategory : category) {
            TabLayout.Tab tab = mTabLayout.newTab().setText(aCategory);
            mTabLayout.addTab(tab);
            mFragments.add(YouKuFragment.newInstance(aCategory));
        }
        mTabLayout.getChildAt(0).setPadding(150, 0, 0, 0);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return super.instantiateItem(container, position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return category[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }


}
