package com.xiong.video.youku;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toolbar;

import com.xiong.video.R;
import com.xiong.video.adpater.ViewPagerAdpater;
import com.xiong.video.bean.YouKuVideoCategoryBean;
import com.xiong.video.bean.YoukuVideoCategoriesBean;
import com.xiong.video.http.RetrofitBuilder;
import com.xiong.video.http.YouKuApi;

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

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tab)
    TabLayout mTabLayout;
    @Bind(R.id.viewpage)
    ViewPager mViewPager;
    private List<Fragment> mFragments;
    private List<String> mTitle;
    private ViewPagerAdpater mPagerAdpater;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youku);
        ButterKnife.bind(this);
        setActionBar(mToolbar);
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
}
