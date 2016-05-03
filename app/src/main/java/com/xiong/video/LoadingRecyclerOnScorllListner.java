package com.xiong.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * LoadingRecyclerOnScorllListner
 * Created by 杨超 on 2016/5/3.
 */
public abstract class LoadingRecyclerOnScorllListner extends RecyclerView.OnScrollListener {
    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int pageSize = 30; // The minimum amount of items to have below your current scroll position before loading more.
    int firstVisibleItem, visibleItemCount, totalItemCount;
    int[] into;

    public LoadingRecyclerOnScorllListner(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = layoutManager.getItemCount();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int spanCount = staggeredGridLayoutManager.getSpanCount();
            if (into == null)
                into = new int[spanCount];
            firstVisibleItem = staggeredGridLayoutManager.findFirstVisibleItemPositions(into)[0];
        }
        if (loading) {
            if (totalItemCount != previousTotal && totalItemCount >= pageSize) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - firstVisibleItem) < pageSize / 2) {
            onLoadMore();
            loading = true;
        }
    }

    public abstract void onLoadMore();
}
