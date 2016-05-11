package com.xiong.video.youku;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.xiong.video.R;
import com.xiong.video.adpater.ViewPagerAdpater;
import com.xiong.video.bean.YouKuVideoCategoryBean;
import com.xiong.video.bean.YoukuVideoCategoriesBean;
import com.xiong.video.http.RetrofitBuilder;
import com.xiong.video.http.YouKuApi;
import com.youku.player.YoukuPlayerBaseConfiguration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * 优酷视频Activity
 * Created by 杨超 on 2016/4/27.
 */
public class YouKuActivity extends AppCompatActivity {
    @Bind(R.id.coordinator_layout)
    CoordinatorLayout mCordinatorLayout;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tab)
    TabLayout mTabLayout;
    @Bind(R.id.viewpage)
    ViewPager mViewPager;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.nav_view)
    NavigationView mNavigationView;

    private List<Fragment> mFragments;
    private List<String> mTitle;
    private ViewPagerAdpater mPagerAdpater;
    private ActionBar mActionBar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youku);
        ButterKnife.bind(this);
        setActionBar(mToolbar);
        mToolbar.setTitle("熊视");
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        mActionBar = getActionBar();
        if (mActionBar != null) {
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_video:
                        Snackbar.make(mCordinatorLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_program:
                        Snackbar.make(mCordinatorLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_setting:
                        Snackbar.make(mCordinatorLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        mPagerAdpater = new ViewPagerAdpater(getSupportFragmentManager());
        mFragments = new ArrayList<>();
        mTitle = new ArrayList<>();
        mPagerAdpater.setFragments(mFragments);
        mPagerAdpater.setTitles(mTitle);
        mViewPager.setAdapter(mPagerAdpater);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getChildAt(0).setPadding(150, 0, 0, 0);
        getCategory();
    }

    private void getCategory() {
        Retrofit retrofit = RetrofitBuilder.getYouKuBuild();
        YouKuApi youKuApi = retrofit.create(YouKuApi.class);
        Call<YouKuVideoCategoryBean> call = youKuApi.getVideoCategory();
        call.enqueue(new Callback<YouKuVideoCategoryBean>() {
            @Override
            public void onResponse(Call<YouKuVideoCategoryBean> call, Response<YouKuVideoCategoryBean> response) {
                if (response.body() != null) {
                    processRequest(response.body());
                }
            }

            @Override
            public void onFailure(Call<YouKuVideoCategoryBean> call, Throwable t) {
                Log.v("tag", t.toString());
            }
        });
    }

    private void processRequest(YouKuVideoCategoryBean categoryBean) {

        for (YoukuVideoCategoriesBean info : categoryBean.getCategories()) {
            mFragments.add(YouKuFragment.newInstance(info));
            mTitle.add(info.getLabel());
        }
        mPagerAdpater.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.menu_search:
                Snackbar.make(mCordinatorLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        YoukuPlayerBaseConfiguration.exit();		//退出应用时请调用此方法
        super.onBackPressed();
    }
}
