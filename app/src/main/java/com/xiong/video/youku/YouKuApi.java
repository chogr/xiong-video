package com.xiong.video.youku;

import com.xiong.video.bean.YouKuBaseVideoBean;
import com.xiong.video.bean.YouKuVideoInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 优酷Api
 * Created by 杨超 on 2016/5/2.
 */
public interface YouKuApi {
    @GET("/v2/videos/by_category.json")
    Call<YouKuBaseVideoBean<YouKuVideoInfo>>
    getVideoInfo(@Query("client_id") String client_id, @Query("category") String category, @Query("page") int page);
}
