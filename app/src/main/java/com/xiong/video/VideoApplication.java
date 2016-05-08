package com.xiong.video;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.youku.player.YoukuPlayerBaseConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Application
 * Created by 杨超 on 2016/5/2.
 */
public class VideoApplication extends Application {
    public static YoukuPlayerBaseConfiguration configuration;
    private List<Activity> activities;

    @Override
    public void onCreate() {
        super.onCreate();
        activities = new ArrayList<>();
        Fresco.initialize(this);
        configuration = new YoukuPlayerBaseConfiguration(this) {
            @Override
            public Class<? extends Activity> getCachingActivityClass() {
                return null;
            }

            @Override
            public Class<? extends Activity> getCachedActivityClass() {
                return null;
            }

            @Override
            public String configDownloadPath() {
                return null;
            }
        };
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
