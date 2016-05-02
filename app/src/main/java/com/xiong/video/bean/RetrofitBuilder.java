package com.xiong.video.bean;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitBuilder
 * Created by 杨超 on 2016/5/2.
 */
public class RetrofitBuilder {
    private static String BASE_YOUKU_UIL = "https://openapi.youku.com";

    public static Retrofit getYouKuBuild() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_YOUKU_UIL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
