package com.xiong.video.bean;

import java.util.List;

/**
 * 优酷视频请求
 * Created by 杨超 on 2016/5/2.
 */
public class YouKuBaseVideoBean<T> {

    /**
     * total : 5598
     * page : 1
     * count : 20
     * videos : []
     */

    private int total;
    private int page;
    private int count;
    private List<T> videos;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getVideos() {
        return videos;
    }

    public void setVideos(List<T> videos) {
        this.videos = videos;
    }
}
