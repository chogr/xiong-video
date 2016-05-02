package com.xiong.video;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Application
 * Created by 杨超 on 2016/5/2.
 */
public class VideoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
