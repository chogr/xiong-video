package com.xiong.video.http;

import com.xiong.video.bean.YouKuBaseVideoBean;
import com.xiong.video.bean.YouKuVideoCategoryBean;
import com.xiong.video.bean.YouKuVideoInfo;
import com.xiong.video.bean.YoukuVideoCategoriesBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 优酷Api
 * Created by 杨超 on 2016/5/2.
 */
public interface YouKuApi {
    @GET("/v2/videos/by_category.json")
    Call<YouKuBaseVideoBean<YouKuVideoInfo>>
    getVideoInfo(@Query("client_id") String client_id, @Query("category") String category, @Query("page") int page);

    @GET("/v2/schemas/video/category.json")
    Call<YouKuVideoCategoryBean>
    getVideoCategory();


}
