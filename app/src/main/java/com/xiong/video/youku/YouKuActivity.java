package com.xiong.video.youku;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import com.xiong.video.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 优酷视频Activity
 * Created by 杨超 on 2016/4/27.
 */
public class YouKuActivity extends Activity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tab)
    TabLayout mTabLayout;
    @Bind(R.id.recycler)
    RecyclerView mRecyclerView;
    @Bind(R.id.refresh)
    SwipeRefreshLayout mSwipeRefieshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youku);
        ButterKnife.bind(this);
        setActionBar(mToolbar);
        String[] category = getResources().getStringArray(R.array.category);
        for (String aCategory : category) {
            TabLayout.Tab tab = mTabLayout.newTab().setText(aCategory);
            mTabLayout.addTab(tab);
        }
        mTabLayout.getChildAt(0).setPadding(150, 0, 0, 0);
    }
}
