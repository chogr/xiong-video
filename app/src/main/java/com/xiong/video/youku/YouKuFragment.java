package com.xiong.video.youku;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiong.video.Key;
import com.xiong.video.LoadingRecyclerOnScorllListner;
import com.xiong.video.R;
import com.xiong.video.adpater.YouKuVideoRecyclerViewAdapter;
import com.xiong.video.bean.YoukuVideoCategoriesBean;
import com.xiong.video.http.RetrofitBuilder;
import com.xiong.video.bean.YouKuBaseVideoBean;
import com.xiong.video.bean.YouKuVideoInfo;
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
 * 优酷Fragment
 * Created by 杨超 on 2016/5/2.
 */
public class YouKuFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.recycler)
    RecyclerView mRecyclerView;
    @Bind(R.id.refresh)
    SwipeRefreshLayout mSimpeRefresh;
    private Context context;
    private View rootView;
    private YoukuVideoCategoriesBean category;
    private YouKuVideoRecyclerViewAdapter mAdapter;
    private List<YouKuVideoInfo> mVideoinfos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_youku, container, false);
            ButterKnife.bind(this, rootView);
            context = getActivity();
            category = getArguments().getParcelable("category");
            mAdapter = new YouKuVideoRecyclerViewAdapter(context);
            mVideoinfos = new ArrayList<>();
            mAdapter.setList(mVideoinfos);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.addOnScrollListener(new LoadingRecyclerOnScorllListner(20) {
                @Override
                public void onLoadMore() {
                    getVideoInfo();
                }
            });
            mSimpeRefresh.setOnRefreshListener(this);
            getVideoInfo();
        }
        return rootView;
    }

    private int page = 1;

    private void getVideoInfo() {
        if (!mSimpeRefresh.isRefreshing()) {
            mSimpeRefresh.setRefreshing(true);
        }
        Retrofit retrofit = RetrofitBuilder.getYouKuBuild();
        YouKuApi youKuApi = retrofit.create(YouKuApi.class);
        Call<YouKuBaseVideoBean<YouKuVideoInfo>> call = youKuApi.getVideoInfo(Key.YOUKU_APP_KEY, category.getLabel(), page);
        call.enqueue(new Callback<YouKuBaseVideoBean<YouKuVideoInfo>>() {
            @Override
            public void onResponse(Call<YouKuBaseVideoBean<YouKuVideoInfo>> call
                    , Response<YouKuBaseVideoBean<YouKuVideoInfo>> response) {
                if (response.body() != null)
                    processRequest(response.body().getVideos());
                if (mSimpeRefresh.isRefreshing()) {
                    mSimpeRefresh.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Call<YouKuBaseVideoBean<YouKuVideoInfo>> call, Throwable t) {
                if (mSimpeRefresh.isRefreshing()) {
                    mSimpeRefresh.setRefreshing(false);
                }
            }
        });
    }

    private void processRequest(List<YouKuVideoInfo> list) {
        if (page == 1)
            mVideoinfos.clear();
        int positionStart = mVideoinfos.size();
        mVideoinfos.addAll(list);
        if (page == 1) {
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter.notifyItemRangeChanged(positionStart, list.size());
        }
        page++;
    }

    public static YouKuFragment newInstance(YoukuVideoCategoriesBean category) {
        YouKuFragment f = new YouKuFragment();
        Bundle args = new Bundle();
        args.putParcelable("category", category);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onRefresh() {
        page = 1;
        getVideoInfo();
    }
}
