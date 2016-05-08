package com.xiong.video;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.youku.player.YoukuPlayerBaseConfiguration;

/**
 * Application
 * Created by 杨超 on 2016/5/2.
 */
public class VideoApplication extends Application {
    public static YoukuPlayerBaseConfiguration configuration;

    @Override
    public void onCreate() {
        super.onCreate();
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
}
